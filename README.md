# eBusiness
eBusiness: Product, Customer and Car Management System 

## Introduction
 - eBusiness is web application which is developed using Java EE with separate Client, Business, Enterprise layers.
 - Note: this project is developed using NetBeans.
 
  ### eBusiness contains 3 tier:
  
      1. Persistence tier  
      - The company sells both brand new cars and used cars, and may extend to more products in
        the future through this general framework. 
      - The car information must be persisted into a Derby database. Use Java
        Persistence API (JPA) to persist the car information into a Derby database. In order to reduce
        code redundancy, use inheritance mapping.
        
      2. Business tier
       - Develop the business tier by using Enterprise Java Beans (EJB). The business tier will process
         the data persistence or retrieval requests from users and interact with the persistence tier
         for accomplishing the requests.
       - the EJBs need to use Java Persistence Query Language (JPQL) to query entities and return the processed results to the         presentation tier.

      3. Presentation tier or View
       - The presentation tier will provide a web-based user interface, which will allow users to enter product details,
         customer details and order details and retrieve these persisted information later on.
         
## The architecture of eBusiness Web Application 
      
![Drawing2](https://user-images.githubusercontent.com/85042722/132318258-16daebaa-a053-47f7-93a3-cfb4efb19eb0.jpg)

#### The main components of application:

1)	Presentation Layer: View and Controller
View: JSF pages, XHTML pages and Bootstrap (css files)
Controller: NewCarController, UsedCarController, CustomerController, OrderController

2)	Business tier: Enterprise Java Bean
EJB Class: carEJB, customerEJB, orderEJB

3)	Persistence tier: Entity Classes (Database Tables)
Entity Classes: Car, NewCar, UsedCar, Customer, Order

#### Create NewCar Workflow:

![workflow](https://user-images.githubusercontent.com/85042722/132318712-e7c67978-0856-4964-af26-7421113b6b83.jpg)

### Manual for compiling and deploying web application:

To run eBusiness web application user must have following software: 

First Glass Fish Server 4 or upper version and Derby database, furthermore Java EE version 8 must be installed on computer system.

Secondly, open command prompt as ADMINISTRATOR rights so user can have complete permission to execute and access each file in system directory. Then write following command to start Glass fish server

asadmin start-domain domain1

![1](https://user-images.githubusercontent.com/85042722/132319235-ab47e5e3-d709-4613-be0a-047b99230980.png)

now, to start Derby database, user need to open another new command prompt as ADMINISTRATOR rights. Then, type following command to start Derby database:

startnetworkserver

Thirdly, in new command prompt, type following command to create pool and data source that connect with Derby database.
This below command creates a pool

asadmin create-jdbc-connction-pool --datasourceclassname=org.apache.derby.ClientDataSource  --restype=javax.sql.DataSource –property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=eBusinessDB:connectionAttributes=;create\=true derby_net_eBusinessDB_APPPool

This below command used to create data source 

asadmin create-jdbc-resource --connectionpoolid derby_net_eBusinessDB_APPPool jdbc/eBusinessDS

Then, deploy .war file and access through localhost.

### How its look:

![1](https://user-images.githubusercontent.com/85042722/132319907-8904086d-f178-4536-87d5-8c8ed1229123.JPG)


