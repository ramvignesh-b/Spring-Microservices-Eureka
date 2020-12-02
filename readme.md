# A simple Login and Register web application with microservice architecture. 

 - Microservice 1 interacts with the UI and passes request and receives response from Microservice 2
 - Microservice 2 interacts with the database and sends appropriate responses for the requests
- The microservices communicate with each other through rest template's exchange method.

![Microservices Diagram](https://github.com/ramvignesh-b/Spring-Microservices-Eureka/blob/main/microservices_flow.jpg)
## Technologies

 - **Frontend**
	 - JSP
	 - CSS3
	 - Vanilla JS
- **Backend**
	- Spring Boot
	- H2 DB *(in memory)*

## Prerequisites

 - Java JDK - 1.8
 - Spring Compatible IDE *(preferably **Spring Tool Suite**)*

 ## How to:
 1. Import the 3 folders individually through maven and let it download the dependencies
 2. Run the following services in order, as a **Spring Boot Application**: 
	- Eureka Server Service
	- MvCDemo2 Application
	- MvCDemo Application
3. Check the status of microservices in Eureka Dashboard
>**localhost:8761** - Eureka Server
**localhost:8080** - UI

