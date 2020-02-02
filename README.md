# EmployeeAPI
REST API implemented in Spring Boot and CRUD operations performed using Oracle Database - 18.3.0.0.0 using JDBC connection.

The code includes two parts-
1. Employees
2. Departments

Each employee can belong to one department.

Implementation steps -

1. Create a maven project and add below parent pom dependency in the pom.xml file to make our project as a child of it. This dependency includes the default configuration and provides plugin management for applications built with Maven.

           <parent>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>1.4.2.RELEASE</version>
           </parent>
	   
2. Add below properties (it is optional) in pom.xml to support java version 8.

            <properties>
			<java.version>1.8</java.version>
	     </properties>
	    
3. We want to create a REST API and this needs below dependency to be added in the pom.xml file. This dependency will inject all the jars required to use the annotations for creating a REST API. For example, @RestController, @RequestMapping etc.

		<dependencies>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
			</dependency>
		</dependencies>

4. Add below dependencies to make oracle db connection using JDBC.

		<dependency>
			<groupId> org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>oracle</artifactId>
			<version>18.3.0.0.0</version>
		</dependency>
		
You might get an error "Missing artifact com.oracle:oracle:jar:18.3.0.0.0"

Download ojdbc8.jar explicitly and place it in a folder, run below command in the folder containing the jar and then you should get a BUILD SUCCESS message.
> mvn install:install-file -Dfile=ojdbc8.jar -DgroupId=com.oracle -DartifactId=oracle -Dversion=18.3.0.0.0 -Dpackaging=jar -DgeneratePom=true

This will inject oracle-18.3.0.0.0.jar in the project's classpath required to make oracle database connection. This step is to be done because the jar is not yet available on maven central repository. 

Update the maven project once and you will see the error is gone and oracle-18.3.0.0.0.jar will be added to the Maven dependencies section.

5. Create a new configuration file application.properties in src/main/resources folder and add below properties.

	   #server port
	   server.port=8081

	   #oracle db settings

	   spring.datasource.url=jdbc:oracle:thin:@localhost:1521/orclpdb
	   spring.datasource.username=<<your username>>
	   spring.datasource.password=<<your password>>
           spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
	   
6. Login to your oracle db schema using sqlplus or any oracle IDE like SQlDeveloper. Create two tables as below

		--Employee table
		CREATE TABLE employee (
    		empid       INTEGER NOT NULL PRIMARY KEY,
    		firstname   VARCHAR2(20) NOT NULL,
    		lastname    VARCHAR2(20) NOT NULL,
    		address     VARCHAR2(100) NOT NULL,
    		deptid      INTEGER NOT NULL,
    		emailid     VARCHAR(20) NOT NULL,
    		CONSTRAINT dept_id_fk FOREIGN KEY ( deptid )
       		 REFERENCES department ( deptid )
            )

		--department table
		CREATE TABLE department (
		    deptid     NUMBER NOT NULL PRIMARY KEY,
		    deptname   VARCHAR2(20) NOT NULL
		);
		
7. REST API endpoints related to employee -

   a. Adding a new employee - 
    	              
	   @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
   
   b. Retrieving all employees -
   			
	   @RequestMapping(value = "/employees", method = RequestMethod.GET)
   
   c. Getting an employee details based on id -
                      
           @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
   
   d. Updating employee details - 
                      
           @RequestMapping(value="/employees/update", method=RequestMethod.PUT)
   
   e. Deleting an employee - 
                      
           @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
		
		
		

