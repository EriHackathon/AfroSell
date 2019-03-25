# AfroSell
This repository will be used to develop the online shopping for AfroSell an online shopping system that provides a platform for selling African products. 

Building online Shopping
~The first month will entail building an online shopping using Java technologies.
In this period of time the first week operation will be building crud operations of retrieving and persisting product information.

Requirements

1. Admin: A shop owner needs to add products, delete,update,edit and see list of products.
2. User: Needs to see list of products.
3. Product: including attributes Name, price, category, type, image,description, rank, date created , date deleted.

~Technologies for Backend
Spring boot,
Hibernate or JPA,
Restful Web Services(REpresentational State Transfer)
Junit Tests
Java se8
MySql Database

~Technologies for front end
Restful Web Services(REpresentational State Transfer)
Html,
CSS,
JSP,
Java Script( Angular framework ) angular 6 or 7
Android app
Restful Web Services(REpresentational State Transfer)
Java se8


The communication of the data will be held by using REST API calls this helps us to develop
different modules separately and can lead to the use of microservice architecture.
The focus on this project is to master and become comfortable with the technologies mentioned.
That way we can leverage the technologies and expand the project accordingly.

Regarding requirements collection, use UML notation specifically user stories and use cases.

USE CASE-001 View Data
Description Web app visitor can view list of products and
it's details which is stored in relational database.
Preconditions A database must exist;0..* products to be posted
Actors Visitor, Server(System)
Normal Sequence
(Happy Path)
Visitor request list of products from the
database
Server connects to the database and lists all
posted jobs details
Post conditions Further actions on the displayed products allowed
Exceptions The requested product(s) does not exist;
either an error is thrown or an empty list is
displayed
The database cannot be accessed; error message is
displayed
