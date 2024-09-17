from __init__ import datetime, openpyxl, os
from model.constants import GITHUIB_USERS, OUTPUT_FILE, OUTPUT_DIR


def save_to_file(dicc, file_name, title = "ICC 2025-I"):
    """
    Save the dictionary to an Excel file.
    Args:
        dicc (dic): contains the data of the form {name: date}
        file_name (str): file name
        title (str, optional): title of the sheet. Defaults to "ICC 2025-I".
    """
    wb = openpyxl.Workbook()
    ws = wb.active
    ws.title = title

    ws.append(["Name", "Date"])

    for nombre, repo in dicc.items():
        ws.append([nombre, repo])

    wb.save(file_name)
    

def load_file(dicc):
    """
    Load the dictionary 
    Args:
        dicc (dicc): Contains the data of the form {name: date} of the 
        assignments
    Returns:
        dicc: A dictionary with the data of the form {name: date} of the
        assignments, ready to save in an Excel file
    """
    new_dicc = {}   
    for k,v in GITHUIB_USERS.items():
        if v in dicc.keys():
            new_dicc[k] = parser_date(dicc[v])
        else:
            new_dicc[k] = ''
    return new_dicc
    
def parser_date(date):
    """
    Transform the date to the format "YYYY-MM-DD"
    Args:
        date (datetime): date of the last commit

    Returns:
        str: date in the format "YYYY-MM-DD"
    """
    if date is None:
        return ''
    
    try:
        date_time = datetime.fromisoformat(str(date))
    except ValueError:
        return ''
    
    if date_time.tzinfo is not None:
        date_time = date_time.replace(tzinfo=None)
    

    return date_time.strftime("%Y-%m-%d")

def load(dicc):
    """
    Load the dictionary and save it in an Excel file
    Args:
        dicc (dicc): dicc with the data of the form {name: date} of the
        assignments
    """
    dicc=load_file(dicc)
    # contcatenate the path
    save_to_file(dicc,  OUTPUT_FILE)
    print('\tSave Success')