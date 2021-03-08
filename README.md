# Container Booking

this project is about Booking container and check available container using Spring boot.

## Library Use

Spring Boot

WebFlux

JPA

HSQLDB (In memory DB)

## What You Need before installation

A favorite text editor or IDE

JDK 11 or later

Maven 3.0+

You can also import the code straight into your IDE:

Spring Tool Suite (STS)

IntelliJ IDEA

## Installation

Goto project root folder, Open command prompt and type bellow command to run application.

```bash
mvn clean install spring-boot:run
```

## Run / Test

Open Postman or Adavanced Rest Client(or we can use any Rest client)

 * [Service 1:] 

	  * Type: `GET`
	  
	  * URL: `http://localhost:8484/api/bookings/checkavailablebooking`
	  
	  * Response : `[{"origin":"Southampton","destination":"Singapore","quantity":5,"containerType":"DRY","containerSize":20}]`
  
 * [Service 2:] 
 
	  * Type: `POST`
	  
	  * URL: `http://localhost:8484/api/bookings/savebookings`
	  
	  * Payload: `{"containerType":"DRY","containerSize":30,"origin":"mumbai","destination":"Pune","quantity":2,"timestamp":"2020-10-11T13:53:09Z"}`
	  
	  * Response : `{"bookingRef":"957000005"}`
