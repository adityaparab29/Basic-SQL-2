import mysql_connection
import csv


def insert_data_in_db(csvFilename, tableName, columnNames, columnCount):
    db_connection = mysql_connection.mysqlconnect()
    # Making Cursor Object For Query Execution
    cursor = db_connection.cursor()
    with open(csvFilename, mode='r') as file:
        # reading the CSV file
        dataCSV = csv.reader(file)
        val = '%s,'
        query = 'INSERT INTO ' + tableName + ' ( ' + columnNames + ') VALUES( '
        for i in range(columnCount):
            query += val
        query = query[:len(query) - 1] + " )"
        print(query)

        for row in dataCSV:
            for i in range(len(row)):
                value = row[i]
                value = value.replace("'", "")

                if "FALSE" == value:
                    value = False
                if "TRUE" == value:
                    value = True

                row[i] = value
            print(row)
            cursor.execute(query, row)

    db_connection.commit()
    cursor.close()
    # Closing Database Connection
    db_connection.close()


bankData = {
    # "BANK_BRANCH": ["Branch_Name", "Assets", "Branch_City"],
    # "ACCOUNT": ["Account_Number", "Balance", "Account_Type", "Interest_Rate", "Overdraft_Amount", "Branch_Name"]
     "BORROW": ["Loan_Number", "Loan_Customer"]
     #"CUS_ACC": ["Account_Number", "Account_Holder", "Access_Date"],
    # "CUST_BANKER": ["Customer_SSN", "Relationship_Officer", "Role"],
    # "CUSTOMER": ["SSN", "Name", "Street", "City"]
    # "DEPENDENT": ["Name", "Employee_SSN"],
    #"EMPLOYEE": ["SSN", "Name", "Telephone_Number", "Start_Date", "Manager_SSN", "Is_Manager"]
    # "LOAN": ["Loan_Number", "Loan_Branch", "Amount"]
     #"PAYMENT": ["Payment_Number", "Payment_Date", "Payment_Amount", "Loan_Number"]
}

bankDataCSV = {
    # "BANK_BRANCH": "Data/BANK_BRANCH.csv",
    # "ACCOUNT": "Data/ACCOUNT.csv"
     "BORROW": "Data/BORROW.csv"
   #  "CUS_ACC": "Data/CUS_ACC.csv",
    # "CUST_BANKER": "Data/CUST_BANKER.csv",
    # "CUSTOMER": "Data/CUSTOMER.csv",
    # "DEPENDENT": "Data/DEPENDENT.csv",
    #"EMPLOYEE": "Data/EMPLOYEE.csv"
    # "LOAN": "Data/LOAN.csv"
    # "PAYMENT": "Data/PAYMENT.csv"
}

for x, y in bankData.items():
    columns = bankData[x]
    columnNames = ', '.join(columns)
    print("Table: " + x)
    insert_data_in_db(bankDataCSV[x], x, columnNames, len(columns))
