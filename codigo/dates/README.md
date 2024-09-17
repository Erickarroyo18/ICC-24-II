
---

# Hunter Date

This mini-project was developed to retrieve the last commit dates of ICC students. It is designed to work seamlessly with any group by simply modifying the project's constants.

## Configuration

The file `model/constants.py` contains the general settings for retrieving commit dates:

> **[IMPORTANT]**
> - `ASSIGNMENT_PREFIX` = *'practice-n-name'* (prefix)
> - `START_DATE_NATIVE` = *datetime.strptime('YYYY-MM-DD', "%Y-%m-%d")* Modify the date to specify from which point the commits will be tracked (ideally, this should be a day before the assignment's start date).
> - `OUTPUT_FILE` = *'icc_pN.xlsx'* (Optional: name of the output file).
> - `LOGGER` = *BOOLEAN* (Can be set to enable or disable debug logging).
> - `GITHUIB_USERS` = *{name:user,...}* (Contains all the students in the current course. If errors arise after modification, please verify the data format. [The format for names should start with last names, without special characters, spaces, and in lowercase]).
> - `SPECIAL_USERS` = ['user_name1',....,`user_nameN`] (List of special cases that cannot be filtered by the default repository suffix).

> **[WARNING]**
> To connect to the GitHub API, you must add your Token to the environment variables. Ensure the Token has the correct permissions for the connection. From the `..dates/src/` directory, run:
```bash
    echo GIT_TOKEN='generated_token'
```

## Execution

After setting up the configuration, run the following command from the `..dates/src/` directory:
```bash
    python main.py
```

## Output

If logging is disabled, the success message will be **Save Success**.

### Contributions

As this is a public repository, anyone can contribute. However, contributors are encouraged to notify and seek approval before submitting changes. Contributions must comply with the project's license.

---

