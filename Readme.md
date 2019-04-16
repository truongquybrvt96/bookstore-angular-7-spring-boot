# Introduction
This is a basic CRUD app using Angular 7 and Java 1.8

## Using

1. Java - 1.8.0
2. Apache Maven - 3.6.1
3. MongoDB - 4.0.8


## Setting up
**1. Clone the source code**
```bash
git clone https://github.com/truongquybrvt96/bookstore-angular-7-spring-boot.git
```

**2. Build and run back-end**
```bash
cd backend
mvn package
java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```
or

```bash
cd backend
mvn spring-boot:run
```

The backend server will run on <http://localhost:8080>.

**3. Build and run front-end**

```bash
cd frontend
npm install
npm start
```

Frontend will run on <http://localhost:4200>

##4. Notes
- Make sure the MongoDB server runs on <http://localhost:27017>.

