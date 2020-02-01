# EmployeeAPI
REST API implemented in Spring Boot and CRUD operations performed using Oracle Database - 18C using JDBC connection.

The code includes two parts-
1. Employees
2. Departments

Each employee can belong to one department.

Implementation steps-

1. Create a maven project and add below parent pom dependency in the pom.xml file to make our project as a child of it. This dependency includes the default configuration and provides plugin management for applications built with Maven.

           <parent>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>1.4.2.RELEASE</version>
           </parent>
	   
2. Add below properties (it is optional) to support java version 8.

           <properties>
			<java.version>1.8</java.version>
	    </properties>


