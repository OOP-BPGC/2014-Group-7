Submission 3:
Classes:	Pending methods:
Student		chooseMess, checkMenu, giveFeedback
SWDAdmin	updateMessOption, doFloppyPosting

Completed Classes:
1) All the under are incorporated into employee classes:
	Cook
	Dishwasher
	Janitor
	Waiter
	Employee
2) MessManager
3) Clerk

Packages:	Classes:
Mess 		Clerk, ClerkClient, Cook, Dishwasher, Employee, EmployeeClient,
			EmployeeLogin, Janitor, MessManager, MessManagerClient, Waiter
User 		Student
SWD 		SWDAdmin

Operations left:
SQL Injection, Email integration.

Special setup:
WampServer downloaded from http://www.wampserver.com/en/ for setting the MySQL database.
mysql-connector-java-5.1.34-bin library to be added in eclipse downloaded from 
http://dev.mysql.com/downloads/connector/j/ for MySQL connection from java to database.

CONSOLE WORKING (using eclipse):
You can check the program working, testing and its flow by running the classes: Student, MessManagerClient, 
ClerkClient and EmployeeClient.

Database:
A file hello.sql which contains the database is to be imported in localhost/phpmyadmin 
(username = "root", password = "") using WampServer.