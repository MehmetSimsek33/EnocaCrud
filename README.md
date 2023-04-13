# EnocaCrud

## Crud Api Spring 

### Prerequisites

* Spring Boot
* Spring Data JPA
* Maven
* Lombok
* PostgreSQL
* ModelMapper

### Run the Application
Clone the source codes into your local system.
* The JDK must be installed. Minimum 1.8 and later versions must be installed for Spring Boot.
* Lombok must be installed
* Database server must be installed
* After the above installations are completed, the installed IDE (STS, Eclipse etc.) is opened and the spring-library-application project is imported.
* After opening the project in Eclipse, paste these codes in the application.properties section. You set the username and password parts while you are installing your database, and you can change accordingly. Then you save.
``` 
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/enocacruddb 
spring.datasource.username=postgres
spring.datasource.password=6352
spring.jpa.properties.javax.persistence.validation.mode = none
```
