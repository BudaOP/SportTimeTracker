# Weekly Sports Time Tracker Application

## 📌 Project Overview

The **Weekly Sports Time Tracker** is a simple Java console application that helps users **log their sports activities, view recorded activities, and calculate total time spent on sports for the week**. This project demonstrates Java programming concepts, unit testing with JUnit, version control with GitHub, and CI/CD integration with Jenkins.

---

## 🚀 Features

- ✅ **Log a sports activity** with name and duration.
- ✅ **View all logged activities**.
- ✅ **Calculate and display total time spent** on sports activities.
- ✅ **Unit testing** with JUnit 5.

---

## 🛠️ Technologies Used

- **Java 17**
- **Maven** for dependency management
- **JUnit 5** for testing
- **GitHub** for version control
- **Jenkins** for CI/CD automation

---

## 📂 Project Structure

```
📁 sportstracker
│── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   ├── com.example
│   │   │   │   ├── SportsTracker.java
│   ├── 📂 test
│   │   ├── 📂 java
│   │   │   ├── SportsTrackerTest.java
│── 📄 pom.xml (Maven configuration)
│── 📄 README.md (Project documentation)
│── 📄 .gitignore (Ignored files)
```

---

## 📥 Installation & Running the Application

### **1️⃣ Clone the repository**

```sh
git clone https://github.com/your-username/sportstracker.git
cd sportstracker
```

### **2️⃣ Compile and Run**

```sh
mvn clean install
java -cp target/sportstracker-1.0-SNAPSHOT.jar com.example.SportsTracker
```

### **3️⃣ Running Tests**

```sh
mvn test
```

---

## 📜 Usage Instructions

1. **Run the application**
2. Choose an option from the menu:
   - `1` Log a new sports activity
   - `2` View all recorded activities
   - `3` View total time spent on sports
   - `4` Exit the application

### **Example Output:**

```
Sports Time Tracker
1. Log activity
2. View activities
3. Total time spent
4. Exit
Choose an option: 1
Enter sport name: Basketball
Enter duration (minutes): 60
Activity added: Basketball (60 min)
```

---

## 🔄 Version Control with GitHub

### **Initialize Git and Push to GitHub**

1. **Initialize Git:**
   ```sh
   git init
   ```
2. **Add and commit code:**
   ```sh
   git add .
   git commit -m "Initial commit - Sports Tracker Application"
   ```
3. **Connect to GitHub repository:**
   ```sh
   git remote add origin https://github.com/your-username/sportstracker.git
   git push -u origin main
   ```

---

## 🤖 Jenkins CI/CD Integration

1. **Set up a Freestyle Project in Jenkins**.
2. **Configure Jenkins to pull from GitHub**.
3. **Add a build step to run Maven tests:**
   ```sh
   mvn clean test
   ```
4. **Add a post-build action to publish JUnit test results**.

---

## 📄 Note

This instruction was made with help of ChatGPT
