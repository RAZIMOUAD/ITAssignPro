# ITAssignPro - IT Project Assignment Management

## 📌 Project Overview
**ITAssignPro** is a web application designed to manage the assignment of employees to IT projects. It allows users to add, edit, and delete employees and projects, as well as assign employees to projects with a specified involvement percentage.

## 🚀 Technologies Used
The project is built using the following technologies:

- **Backend:** Jakarta EE 11 (JSF, JPA, CDI)
- **Framework:** JavaServer Faces (JSF 4.0)
- **Database:** MySQL
- **ORM:** EclipseLink (JPA)
- **Server:** Apache Tomcat 10.1.34
- **Build Tool:** Maven
- **Frontend:** Bootstrap 5.3.2

## 📂 Project Structure
The project follows a well-defined MVC architecture with clear separation of concerns:

```
ITAssignPro/
├── src/main/java/org/example/itassignpro/
│   ├── model/            # JPA Entities (Employee, Project)
│   ├── dao/              # DAO Layer (EmployeeDAO, ProjectDAO)
│   ├── controller/       # Managed Beans (EmployeeController, ProjectController)
│   ├── service/          # Business Logic (AssignmentService)
│   ├── util/             # Utilities (JPAUtil)
│
├── src/main/webapp/
│   ├── index.xhtml       # Home Page
│   ├── employeeList.xhtml # Employee Management
│   ├── projectList.xhtml  # Project Management
│   ├── affectation.xhtml  # Employee Assignment to Projects
│   ├── templates/        # Shared Layout (header.xhtml, footer.xhtml)
│   ├── assets/css/       # Custom CSS Styles
│   ├── web.xml           # Deployment Configuration
│   ├── faces-config.xml  # JSF Configuration
│   ├── beans.xml         # CDI Configuration
│
├── pom.xml               # Maven Configuration
└── README.md             # Project Documentation
```

## ⚙️ Installation & Configuration
### 1️⃣ Prerequisites
- **Java 22**
- **Apache Tomcat 10.1.34**
- **MySQL** 
- **Maven**
- **Git**

### 2️⃣ Installation
Clone the project:
```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/ITAssignPro.git
cd ITAssignPro
```

### 3️⃣ Database Configuration
Create a MySQL database:
```sql
CREATE DATABASE itassignpro;
```
Modify `persistence.xml` with your MySQL settings:
```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/itassignpro"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value=""/>
```

### 4️⃣ Build & Deployment
Compile and package the application:
```bash
mvn clean package
```
Deploy to Tomcat:
```bash
cp target/ITAssignPro.war $TOMCAT_HOME/webapps/
```
Or use exploded mode with IntelliJ IDEA for development.

## 🛠 Key Features
- ✅ **Employee Management**: Add, edit, delete employees
- ✅ **Project Management**: Add, edit, delete projects
- ✅ **Assignment System**: Assign employees to projects with a percentage
- ✅ **Modern UI**: Bootstrap 5.3.2-based user interface

## 🔧 Git Commands
To initialize Git for the project:
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/ITAssignPro.git
git push -u origin main
```

---
🚀 Developed with ❤️ by [Your Name or Team]

