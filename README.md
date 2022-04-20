# lease-loco-assignment

## Instalation instructions -

In order for the application to function you will need to create an empty MYSQL database named lease_loco.

After cloning the repository to your desired location, open the project in your IDE. 

Navigate to scr/main/resources/ and open the "application.properties" file.

Set the database and password properties to that of the root account of your MySQL database.

Now run the program and dependencies should be installed during the initial build.

## About -

Spring Boot application using Spring Batch to read multi-format car deal csv data into a single format and write to a MySQL database.

The application reads all ".csv" files contained in src/main/resources/input automatically on startup so all 
the deal data should now be held in the database

Deals can be retrieved from the DB via GET request to the URL http://localhost:8080/api/deals/ and any combination of the 
"deal_id", "make", "model", "price_£", "term", "mileage" and "description" parameters -

                e.g. http://localhost:8080/api/deals/?make=AUDI&model=A5&term=24 will return all 24 month Audi A5 lease deals


## API Documentation - 

While the application is running API documentation can be found at http://localhost:8080/swagger-ui/index.html



