# Getting Started

## How to run this project

1. Run the docker-compose.yml
2. From a terminal login to the db in the docker.
```
docker exec -it postgres bash
```
3. Use the postgres command line client psql
```
psql -U pbs
```
3. Create and create an empty database: **customer**
```
CREATE DATABASE customer;
```
4. Run the Application maven project

## Endpoints

### addCustomer
```
curl --location --request POST 'localhost:8080/api/v1/customers' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Alex",
"email": "alex@gmail.com",
"age": 26
}'
```

### updateCustomer

```
curl --location --request PUT 'localhost:8080/api/v1/customers/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Pablo",
"email": "pablo@gmail.com",
"age": 41
}'
```

### getCustomers

```
curl --location --request GET 'http://localhost:8080/api/v1/customers'
```

### getCustomerById

```
curl --location --request GET 'http://localhost:8080/api/v1/customers/1'
```

### deleteCustomer

```
curl --location --request DELETE 'http://localhost:8080/api/v1/customers/3'
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
