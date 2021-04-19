SpringBoot Application having banking functionalities.

Made 2 entities, 2 repositories, 2 service class and 2 controllers for this application.

1st entity is for customer class, having id(primary key), firstname, lastname, and balance as attributes. The contoller for this entity can do the following:
1) add new customers(POST)
2) update information on existing customers(PUT)
3) delete the customers(DELETE)
4) find all customers
5) find customer by account id 
6) find customer by firstname.

Exception handling and unit testing for this controller has been done to see everything works fine.

2nd entity is for transact class, having transid(primary key,self generated), account id, tranfer balance, inout(boolean true means credit and false means debit). The controller for this entity can do the following:
1) view all Transactions
2) view all transactions from a specific account id
3) debit money from a specific account id
4) Credit money to a specific account id
5) tranfer money between 2 account ids(debit action from one, credit to another)

Exception handling added for this transaction controller if amount to be debited is greater than the account balance an exception is thrown.


Work done:
14th April: Assignment recieved to make a springboot application with REST service having banking functionalities. Made the entity, repo, service and controller for customers and added exception handling and unit tests to it.

15th April: Extended the application by making the entity, repo, service and controller for transctions and added exception handling to it.

16th April: Feedback on assignment after demonstration and made changes according to it such as adding lombok, making balance amount as double, making controller class as having to call functions, adding logger, and property file value fetching to set a limit on the amount per transaction.



