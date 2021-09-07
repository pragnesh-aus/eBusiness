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
       - the EJBs need to use Java Persistence Query Language (JPQL) to query entities and return the processed results to the          presentation tier.

      3. Presentation tier or View
       - The presentation tier will provide a web-based user interface, which will allow users to enter product details,
         customer details and order details and retrieve these persisted information later on. 
      
