# Selenium Amazon Price Automation

## 📌 About Project
This project uses Selenium WebDriver to automate Amazon website.

It searches for a product and prints the price of the first result.

---

## ✅ Test Cases

### Test Case 1
- Search for "iPhone"
- Open first product
- Print price

### Test Case 2
- Search for "Samsung Galaxy"
- Open first product
- Print price

---

## ⚡ Parallel Execution
Both test cases run in parallel using TestNG.

---

## 🛠️ Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven

---

## 📂 Project Structure
## Project Structure

```
selenium-amazon-test/
├── pom.xml              # Maven dependencies and build config
├── testng.xml           # TestNG suite configuration
├── README.md            # Project documentation
└── src/test/java/
    └── AmazonTest.java  # Selenium test cases for Amazon
```


---

## ▶️ How to Run

### Option 1 (Easy - IntelliJ)
1. Clone the project
2. Open in IntelliJ IDEA
3. Right click `testng.xml`
4. Click Run

---

### Option 2 (Optional - Maven)
If Maven is installed:

mvn test


## 📊 Output Example
iPhone Price: ₹1,74,900
Samsung Galaxy Price: ₹89,999


---

## 👨‍💻 Author
Jatin Agrawal
