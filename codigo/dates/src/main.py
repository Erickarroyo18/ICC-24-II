import __init__
from control.controller import get_user_date
from model.loader import load


def main():
    dicc = get_user_date()
    #print(len(dicc))
    #for k,v in dicc.items():
    #    print(f"{k} - {v}")
    load(dicc)
 
   
    
if __name__ == "__main__":
    main()