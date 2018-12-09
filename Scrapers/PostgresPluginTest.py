import unittest
import psycopg2
import PostgresPlugin

class TestPostgresPlugin(unittest.TestCase):
    def setUp(self):
        self.DBConn = PostgresPlugin.connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
        self.testSupport = UnitTestSupport()


    def testupdateRMP(self):
        PostgresPlugin.updateRMP("KIM","G", "4.8")
        sections = self.testSupport.grabSections("KIM", "G")
        for section in sections:
            self.assertEqual(section[6], '4.8')

    def testupdateCIS(self):
        PostgresPlugin.updateCIS("KIM","G", "-1")
        sections = self.testSupport.grabSections("KIM", "G")
        for section in sections:
            self.assertEqual(section[7], '-1')

    def testinsertNewSection(self):
        PostgresPlugin.insertNewSection(00000, "Q", "Q", "Q", "TEST", "Q", "Q", "Q")
        sections = self.testSupport.grabSections("TEST", "Q")
        for section in sections:
            self.assertEqual(section[1], 'Q')
        self.testSupport.deleteSection(0)


class UnitTestSupport():
    def grabSections(self, lastName, firstInitial):
        DBConn = PostgresPlugin.connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
        DB = DBConn.cursor()
        DB.execute("""SELECT * FROM softwarelab.registrar
                        WHERE "professor-last-name" = '%s'
                        AND "professor-first-initial" = '%s'""" % (lastName, firstInitial))
        return DB.fetchall()

    def deleteSection(self, uniqueNumber):
        DBConn = PostgresPlugin.connectToDB('postgres', 'softwarelabinstance.ct09nasdzura.us-east-1.rds.amazonaws.com', 'administrator', 'password')
        DB = DBConn.cursor()
        DB.execute("""DELETE FROM softwarelab.registrar
                        WHERE "unique-number" = %d""" % (uniqueNumber))
        DBConn.commit()

if __name__ == '__main__':
    unittest.main()
