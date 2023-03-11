import mysql.connector


def mysqlconnect():
    try:
        db_connection = mysql.connector.connect(
            host="acadmysqldb001p.uta.edu",
            user="axp9807",
            password="A@vE30ENGErS",
            database="axp9807"
        )
    # If connection is not successful
    except:
        print("Can't connect to database")
        return 0
    print("Connected")

    return db_connection
