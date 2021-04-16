SpringBoot Application having banking functionalities.

Made 2 entities, 2 repositories, 2 service class and 2 contollers for this application.

1st entity is for customer class, having id(primary key), firstname, lastname, and balance as attributes. The contoller for this entity can do the following:
1) add new customers(POST)
2) update information on existing customers(PUT)
3) delete the customers(DELETE)
4) find all customers
5) find customer by account id 
6) find customer by firstname.

Exception handling and unit testing for this contoller has been done to see everything works fine.

2nd entity is for transact class, having transid(primary key,self generated), account id, tranfer balance, inout(boolean true means credit and false means debit). The controller for this entity can do the following:
1) view all Transactions
2) view all transactions from a specific account id
3) debit money from a specific account id
4) Credit money to a specific account id
5) tranfer money between 2 account ids(debit action from one, credit to another)
