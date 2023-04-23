# HotelReservationApp
A console app to reserve rooms in a hotel.

## Software Requirements

To run this application the following software must be installed:

- Java SDK 20+

```shell
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % java --version
openjdk 20 2023-03-21
OpenJDK Runtime Environment Homebrew (build 20)
OpenJDK 64-Bit Server VM Homebrew (build 20, mixed mode, sharing)
```

- Maven 3.9.1+

```shell
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % mvn -v
Apache Maven 3.9.1 (2e178502fcdbffc201671fb2537d0cb4b4cc58f8)
Maven home: /usr/local/Cellar/maven/3.9.1/libexec
Java version: 20, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk/20/libexec/openjdk.jdk/Contents/Home
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "13.1", arch: "x86_64", family: "mac"
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % 
```

## Installation

- To install the application run the command `mvn clean install`

```shell
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.hotel.app:hotel-app >-----------------------
[INFO] Building hotel-app 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ hotel-app ---
[INFO] Deleting /Users/luisapinto/IdeaProjects/HotelReservationApplication/target
[INFO] 
[INFO] --- resources:3.3.0:resources (default-resources) @ hotel-app ---
[INFO] Copying 0 resource
[INFO] 
[INFO] --- compiler:3.8.0:compile (default-compile) @ hotel-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 26 source files to /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/classes
[INFO] 
[INFO] --- resources:3.3.0:testResources (default-testResources) @ hotel-app ---
[INFO] Copying 0 resource
[INFO] 
[INFO] --- compiler:3.8.0:testCompile (default-testCompile) @ hotel-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/test-classes
[INFO] 
[INFO] --- surefire:3.0.0:test (default-test) @ hotel-app ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.hotel.app.model.CustomerTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.056 s - in com.hotel.app.model.CustomerTest
[INFO] Running com.hotel.app.model.ReservationTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 s - in com.hotel.app.model.ReservationTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ hotel-app ---
[INFO] Building jar: /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/hotel-app-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.0:install (default-install) @ hotel-app ---
[INFO] Installing /Users/luisapinto/IdeaProjects/HotelReservationApplication/pom.xml to /Users/luisapinto/.m2/repository/com/hotel/app/hotel-app/0.0.1-SNAPSHOT/hotel-app-0.0.1-SNAPSHOT.pom
[INFO] Installing /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/hotel-app-0.0.1-SNAPSHOT.jar to /Users/luisapinto/.m2/repository/com/hotel/app/hotel-app/0.0.1-SNAPSHOT/hotel-app-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.010 s
[INFO] Finished at: 2023-04-23T22:45:52+01:00
[INFO] ------------------------------------------------------------------------
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % 
```

## Package the application

- To package the application run the command `mvn clean package`

```shell
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % mvn clean package
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.hotel.app:hotel-app >-----------------------
[INFO] Building hotel-app 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ hotel-app ---
[INFO] Deleting /Users/luisapinto/IdeaProjects/HotelReservationApplication/target
[INFO] 
[INFO] --- resources:3.3.0:resources (default-resources) @ hotel-app ---
[INFO] Copying 0 resource
[INFO] 
[INFO] --- compiler:3.8.0:compile (default-compile) @ hotel-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 26 source files to /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/classes
[INFO] 
[INFO] --- resources:3.3.0:testResources (default-testResources) @ hotel-app ---
[INFO] Copying 0 resource
[INFO] 
[INFO] --- compiler:3.8.0:testCompile (default-testCompile) @ hotel-app ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/test-classes
[INFO] 
[INFO] --- surefire:3.0.0:test (default-test) @ hotel-app ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.hotel.app.model.CustomerTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.055 s - in com.hotel.app.model.CustomerTest
[INFO] Running com.hotel.app.model.ReservationTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 s - in com.hotel.app.model.ReservationTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.3.0:jar (default-jar) @ hotel-app ---
[INFO] Building jar: /Users/luisapinto/IdeaProjects/HotelReservationApplication/target/hotel-app-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.334 s
[INFO] Finished at: 2023-04-23T22:48:03+01:00
[INFO] ------------------------------------------------------------------------
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % 
```

## Run the Application

- First run the installation or package commands as show in sections above

- Then run the application with the command `java -cp target/hotel-app-0.0.1-SNAPSHOT.jar src/main/java/com/hotel/app/HotelApplication.java`

```shell
luisapinto@Luisas-MacBook-Pro HotelReservationApplication % java -cp target/hotel-app-0.0.1-SNAPSHOT.jar src/main/java/com/hotel/app/HotelApplication.java
Welcome to the Hotel Reservation Application

=====================================
|           Main  Menu              |
=====================================
| Options:                          |
| 1. Find and reserve a room        |
| 2. See my reservations            |
| 3. Create an account              |
| 4. Admin                          |
| 5. Exit                           |
=====================================
Please type a number for the menu option: 5
```
