# Selenium Hybrid Test Automation Framework

A scalable and maintainable Hybrid Test Automation Framework built using **Selenium WebDriver**, **Java**, and **TestNG**. Designed to support both data-driven and keyword-driven testing, this framework follows industry best practices and aims to accelerate UI test automation with clean code architecture.

---

## 🧩 Framework Highlights

- ✅ Selenium WebDriver with Java
- ✅ Hybrid design: Keyword-Driven + Data-Driven
- ✅ TestNG for test execution and assertions
- ✅ Page Object Model (POM) for modularity and reusability
- ✅ Excel-based test data handling via Apache POI
- ✅ Configuration management using `config.properties`
- ✅ ExtentReports integration for detailed HTML reports
- ✅ Maven for dependency management and build automation

---

## 🗂️ Project Structure

selenium-hybrid-test-framework/ 
│ ├── src/ │ ├── test/java/ │ │ ├── tests/ # Test cases (TestNG) │ │ ├── pages/ # Page Object Model classes │ │ ├── keywords/ # Generic keyword action handlers │ │ └── utils/ # Utility classes (Excel, config, etc.) │ ├── test-data/ │ └── testdata.xlsx # Excel sheet for test input │ ├── config/ │ └── config.properties # Framework and environment settings │ ├── reports/ │ └── ExtentReports/ # Execution reports │ ├── pom.xml # Maven dependencies and plugins └── README.md # Project documentation
---

## 🚀 Getting Started

### 📦 Prerequisites

- Java Development Kit (JDK) 8 or above
- Maven installed and configured
- IDE (Eclipse, IntelliJ IDEA, or VS Code)
- Git installed

### 🔧 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/hrushishete/selenium-hybrid-test-framework.git
   cd selenium-hybrid-test-framework
Configure properties

Set application URLs and driver paths in config/config.properties

Modify test data in test-data/testdata.xlsx if needed

Run tests

mvn clean test
📊 Reports
After execution, test results are available at:

/reports/ExtentReports/
Includes:

Test steps and outcomes

Screenshot capture on failures

Timestamped HTML report

👨‍💻 Author
Hrushi Shete

📧 Email: hrushishete@gmail.com

🔗 GitHub: github.com/hrushishete

💼 Open to roles in QA & Test Automation

🌱 Passionate about continuous learning and test engineering

---

For any query or suggestions please do comment or mail @ hrushishete@gmail.com
