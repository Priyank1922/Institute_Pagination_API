# 📚 Institute Student Management System

A **Spring Boot REST API** built to demonstrate **CRUD Operations**, **Pagination**, **Sorting**, and **Searching** using **Spring Data JPA**.

This project is designed to showcase how large datasets can be efficiently managed by retrieving only the required records instead of loading the complete database.

---

# 🚀 Features

*  Create Student
*  Get All Students
*  Get Student By ID
*  Update Student
*  Delete Student
*  Pagination
*  Sorting (Ascending & Descending)
*  Search by Name
*  Global Search (Name, Surname, Email)
*  RESTful API Design
*  MySQL Database Integration
*  Spring Data JPA
*  Lombok Integration

---

# 🛠 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* REST API
* Postman (API Testing)

---

# 📂 Project Structure

```
src
├── controller
│      InstituteController
│
├── entity
│      Institute_Student
│
├── repository
│      InstituteRepository
│
├── service
│      InstituteService
│
└── resources
       application.properties
```

---

# 📌 Student Entity

| Field   | Type   |
| ------- | ------ |
| id      | Long   |
| name    | String |
| surname | String |
| gender  | String |
| email   | String |

---

# 🌐 Base URL

```
http://localhost:8080/institute
```

---

# 📖 API Endpoints

---

## 1. Create Student

**POST**

```
POST /institute
```

### Request Body

```json
{
    "name":"Priyank",
    "surname":"Mehta",
    "gender":"Male",
    "email":"priyank@gmail.com"
}
```

### Response

```json
{
    "id":1,
    "name":"Priyank",
    "surname":"Mehta",
    "gender":"Male",
    "email":"priyank@gmail.com"
}
```

---

## 2. Get All Students

**GET**

```
GET /institute/all
```

Returns all students without pagination.

---

## 3. Get Student By ID

**GET**

```
GET /institute/{id}
```

Example

```
GET /institute/5
```

Returns a single student.

---

## 4. Update Student

**PUT**

```
PUT /institute/{id}
```

Example

```
PUT /institute/5
```

### Request Body

```json
{
    "name":"Rahul",
    "surname":"Sharma",
    "gender":"Male",
    "email":"rahul@gmail.com"
}
```

---

## 5. Delete Student

**DELETE**

```
DELETE /institute/{id}
```

Example

```
DELETE /institute/5
```

Response

```
Student with ID 5 deleted successfully!
```

---

# 📄 Pagination API

Retrieve records page by page.

**GET**

```
GET /institute
```

### Query Parameters

| Parameter | Description       | Default |
| --------- | ----------------- | ------- |
| page      | Page Number       | 0       |
| size      | Number of Records | 5       |
| sortBy    | Sorting Field     | id      |
| sortDir   | asc / desc        | asc     |

Example

```
GET /institute?page=0&size=5
```

---

# 🔃 Pagination + Sorting

Example

```
GET /institute?page=0&size=5&sortBy=name&sortDir=asc
```

Descending

```
GET /institute?page=0&size=5&sortBy=email&sortDir=desc
```

---

# 🔍 Global Search + Pagination + Sorting

Searches across:

* Name
* Surname
* Email

Example

```
GET /institute?search=rahul
```

With Pagination

```
GET /institute?page=0&size=5&search=rahul
```

With Sorting

```
GET /institute?page=0&size=5&sortBy=name&sortDir=asc&search=rahul
```

---

# 🔍 Search by Name

Search only in the **name** field.

```
GET /institute/search
```

Example

```
GET /institute/search?name=Priyank
```

With Pagination

```
GET /institute/search?name=Priyank&page=0&size=5
```

With Sorting

```
GET /institute/search?name=Priyank&page=0&size=5&sortBy=name&sortDir=desc
```

---

# 📊 Pagination Response

The pagination API returns additional metadata.

```json
{
    "content":[
        {
            "id":1,
            "name":"Priyank",
            "surname":"Mehta",
            "gender":"Male",
            "email":"priyank@gmail.com"
        }
    ],
    "pageable":{},
    "totalPages":5,
    "totalElements":25,
    "last":false,
    "size":5,
    "number":0,
    "sort":{},
    "first":true,
    "numberOfElements":5,
    "empty":false
}
```

---

# 💡 Sorting Options

You can sort using any entity field.

Examples

```
sortBy=id
sortBy=name
sortBy=surname
sortBy=email
sortBy=gender
```

Direction

```
sortDir=asc
```

or

```
sortDir=desc
```

---

# 📌 Repository Methods

```java
findAll(Pageable pageable)

findByNameContainingIgnoreCase()

searchStudents()
```

The custom JPQL query performs keyword-based searching across multiple fields:

* Name
* Surname
* Email

---

# ▶️ How to Run

1. Clone the repository.

```
git clone <repository-url>
```

2. Open the project in your IDE.

3. Configure MySQL in `application.properties`.

4. Create the database.

5. Run the Spring Boot application.

6. Test APIs using Postman.

---

# 🎯 Learning Outcomes

This project demonstrates:

* REST API Development
* Spring Boot Architecture
* Spring Data JPA
* CRUD Operations
* Pagination
* Sorting
* Dynamic Search
* JPQL Custom Queries
* Pageable & Page API
* Repository Pattern
* Service Layer Design
* MVC Architecture

---

# 👨‍💻 Author

**Priyank Mehta**


If you found this project useful, consider giving the repository a ⭐.
