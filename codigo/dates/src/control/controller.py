from __init__ import Github, os, load_dotenv, re
from model.constants import ORG_NAME, ASSIGNMENT_PREFIX, START_DATE, SPECIAL_USERS, LOGGER

# load the environment variables
load_dotenv()

def authenticate_connect():
    """
    Authenticate to Github
    Raises:
        ValueError: If the token is not found

    Returns:
        user_login: user authenticated
    """
    try:
        token = os.getenv('GIT_TOKEN')
        g = Github(token)

        if not token:
            raise ValueError("Token dont found, try to set the GIT_TOKEN environment variable")
    except Exception as e:
        print(f"Error: fail GitHub authenticate: {e}")
        raise
    return g

def get_org(g : Github):
    """
    Get the organization from Github
    Args:
        g (Github): user authenticated

    Returns:
        org: connection to the organization
    """
    try:
        # get the organization
        org = g.get_organization(ORG_NAME)
        if LOGGER:
            print(f"Connect to organization: {ORG_NAME}")
    except Exception as e:
        print(f"Error: Organization could not be found  {e}")
        raise
    return org

def get_repos_from_org(org, prefix= None, start_date= None):
    """
    Get the repositories from the organization, can filter by prefix and start date
    Args:
        org (org): Organization connection
        prefix (str, optional): filter prefix . Defaults to None.
        start_date (datetime, optional): from to date. Defaults to None.
        

    Returns:
        paginatedList: list of repositories
    """
    try:
        # Listar los repositorios de la organización
        repos = org.get_repos()
        print(f"All repositories in organization {ORG_NAME}: {repos.totalCount}")
        # Filtro por prefijo
        if prefix is not None:
            if LOGGER:
                print(f"Filter by prefix {prefix}")
            repos = [repo for repo in repos if prefix in repo.name]
            if LOGGER:
                print(f"Repositories with prefix {len(repos)}")
        # Filtro por fecha
        if start_date is not None:
            if LOGGER:
                print(f"Filter by start date: {start_date}")
            repos = [repo for repo in repos if repo.created_at >= start_date]
            if LOGGER:
                print(f"Total {len(repos)} repositories after {start_date}")
    except Exception as e:
        print(f"Error: Can't get the repositories {e}")
        raise
    return repos


def get_last_commit_date(repos):
    """
    Get the last commit date of the repositories
    Args:
        repos (paginatedList): List of repositories

    Returns:
        dicc: Constains the data of the form {name: date} of the last commits of the assignments
    """
    dicc = {}
    for repo in repos:
        try:
            commits = repo.get_commits()  #get all commits
            if commits.totalCount > 0:
                last_commit = commits[0] # get the last commit
                usuario = get_git_user(last_commit,repo.name)
                if usuario is not None:
                    dicc[usuario] = last_commit.commit.author.date
                    if LOGGER:
                        print(f"Repository: {repo.name} user: {usuario} - last commit: {last_commit.commit.author.date}")
                else:
                    dicc[usuario] = ''
            else:
                if LOGGER:
                    print(f"Repository: {repo.name} - Iniitial commit.")
        except Exception as e:
            print(f"Error: In repository {repo.name}: {e}")
    return dicc

def get_user_date():
    """
    Load the dictionary that contains the data of the form {name: date} of the 
    commits of the assignments
    Returns:
        dicc: dicc with the data of the form {name: date} 
    """
    g = authenticate_connect()
    org = get_org(g)
    repos = get_repos_from_org(org, prefix= ASSIGNMENT_PREFIX, start_date= START_DATE)
    dicc = get_last_commit_date(repos)
    return dicc


def get_git_user(commit, repo_name):
    """
    Get the user from the commit
    Args:
        commit (PaginatedList): list of commits
        repo_name (str): repo name of a assignment 

    Returns:
        _type_: _description_
    """
    try:
        # especial case
        if special_case(repo_name) is not None:
            return special_case(repo_name)
        # try to get the user from the commit
        user = commit.author.login if commit.author else None
        
        # If the user is not found, try to get it from the repo name
        if user is None:
            # remove the last part of the repo name if it is a number
            user = re.sub(r'-\d+$', '', repo_name)
            user = user.split('-')[-1] 
        if user == 'github-classroom[bot]':
            return None
    except Exception as e:
        print(f"Error: Can't get user name {e}")
        user = "ERROR"
    
    return user

def special_case(case):
    """
    Check if the repo name is a special case
    Args:
        case (str): have the form repo_prefix-user

    Returns:
        str: equivalent user in the SPECIAL_USERS list
    """
    for sc in SPECIAL_USERS:
        if sc in case:
            return sc
    return None