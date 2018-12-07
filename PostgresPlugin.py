import psycopg2

# attempts to connect to a database with the specified dbname, hostname, username, and password. returns the database connection object
def connectToDB(dbname, host, username, password):
    try:
        return psycopg2.connect(
            "dbname ='%s' user ='%s' host ='%s' password ='%s'" % (dbname, username, host, password))
    except:
        print "I am unable to connect to " + host
    return None

# inserts a new section into the registrar table. Pass in None to the LabDays parameter if there is no Lab.
def insertNewSection(UniqueNumber, LectureDays, LectureStart, LectureEnd, LastName, FirstInitial, Prefix, Number):
    DBConn = connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
    DB = DBConn.cursor()
    DB.execute("""INSERT INTO softwarelab.registrar ("unique-number", "lecture-days", "lecture-start", "lecture-end", "professor-last-name", "professor-first-initial", prefix, "number")
                    VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s')""" % (UniqueNumber, LectureDays, LectureStart, LectureEnd, LastName, FirstInitial, Prefix, Number))
    DBConn.commit()

# updates an existing entry with the RMP rating based on last name and first initial
def updateRMP(LastName, FirstInitial, Rating):
    DBConn = connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
    DB = DBConn.cursor()
    DB.execute("""UPDATE softwarelab.registrar
                    SET "rmp-rating" = '%s'
                    WHERE "professor-last-name" = '%s'
                    AND "professor-first-initial" = '%s'""" % (Rating, LastName, FirstInitial))
    DBConn.commit()

# updates an existing entry with the CIS rating based on the last name and first initial
def updateCIS(LastName, FirstInitial, Rating):
    DBConn = connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
    DB = DBConn.cursor()
    DB.execute("""UPDATE softwarelab.registrar
                    SET "cis-grade-distribution" = '%s'
                    WHERE "professor-last-name" = '%s'
                    AND "professor-first-initial" = '%s'""" % (Rating, LastName, FirstInitial))
    DBConn.commit()
