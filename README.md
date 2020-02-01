# EmployeeAPI
REST API implemented in Spring Boot and CRUD operations performed using Oracle Database - 18C using JDBC connection.

The code includes two parts-
1. Employees
2. Departments

Each employee can belong to one department.

Implementation steps-

1. Create a maven project and add below dependency in the pom to make our project as a child of it. This dependency includes the default configuration of Spring boot.

<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.2.RELEASE</version>
</parent>


