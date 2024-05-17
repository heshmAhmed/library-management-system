# Library Management System

## Build the Application

Run the following command to build the application:

```bash
   ./mvnw clean package
```

## Run the Application
- Make sure that you have a postgres database running on `localhost` on port `5432` with name `library_db` and
username and password `maid.cc`
- To run the application, execute the following command:
```
java -jar target/library-management-system.jar
```
## Interacting with API Endpoints
Once the application is running, you can interact with the API endpoints using tools like cURL, Postman, or any HTTP client library in your preferred programming language.

## Example API Endpoints
- #### Retrieve All Books:
```
GET http://localhost:8080/library/api/books
```
- #### Retrieve a Specific Book by ID:
```
GET http://localhost:8080/library/api/books/{id}
```
- #### Add a New Book:
```
POST http://localhost:8080/api/books
Content-Type: application/json

{
  "title": "New Book",
  "author": "John Doe",
  "publicationYear": 2022,
  "isbn": "123-1234567890"
}
```
- #### Update an Existing Book:
```
PUT http://localhost:8080/api/books/{id}
Content-Type: application/json

{
  "title": "Updated Book",
  "author": "Jane Doe",
  "publicationYear": 2023,
  "isbn": "123-1234567890"
}
```
- #### Delete a Book:
```
DELETE http://localhost:8080/api/books/{id}
```










