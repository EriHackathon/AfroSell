# AfroSell
This repository will be used to develop the online shopping for AfroSell
Building online Shopping
For this month we will gradually build an online shopping using Java technologies,
In this period of time the first week operation will be building a crud operations.
Requirement
Admin
1. A shop owner needs to add products, delete,update,edit and see list of products.
User
Needs to see list of products.
Let's not focus on the quality of the UI but at least it should look like somehow explatory.
Product attributes includes
Name, price, category, type, image,description, rank, date created , date deleted.
~Technology for Backend
Spring boot,
Hibernate or JPA,
Restful Web Services(REpresentational State Transfer)
Junit Tests
Java se8 (let’s try to use lambda expressions)
MySql Database
~Technology for front end
Restful Web Services(REpresentational State Transfer)
Html,
CSS,
JSP,
Java Script( Angular framework ) angular 6 or 7
Android app
Restful Web Services(REpresentational State Transfer)
Java se8
The communication of the data will be held by using REST API calls this helps us to develop
different modules separately and we can use microservice architecture.
The focus on this project is to master and become comfortable with the technologies mentioned.
That way we can expand the project accordingly.
Regarding Requirements collection, using UML notation specifically user stories and use cases
… i always start with those. As to create a firm and also flexibile documentation to add on
USE CASE-001 View Data
Description Web app visitor can view list of products and
it's details which is stored in relational database
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
N.B i’m having hard time adding table into this google doc, coz i’m working on office libre. Let’s
create github repo… we can even try out the new github documentation which i never tried
before.
