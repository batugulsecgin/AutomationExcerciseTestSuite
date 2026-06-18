# Automation Exercise - BDD Test Automation Framework

This repository contains a robust, scalable, and fully functional Test Automation Framework built for the [Automation Exercise](https://automationexercise.com/) website. The framework is designed using **Java**, **Selenium WebDriver**, and **Cucumber (BDD)**, adhering strictly to **Page Object Model (POM)** and **Clean Code** principles.

## 🚀 Tech Stack & Tools
* **Programming Language:** Java 26
* **Browser Automation:** Selenium WebDriver (v4.21.0)
* **BDD Framework:** Cucumber (v7.18.0)
* **Test Runner:** JUnit 4
* **Build Tool:** Apache Maven
* **Driver Management:** WebDriverManager

## 🏗️ Architecture & Design Patterns
* **Behavior Driven Development (BDD):** Scenarios are written in Gherkin syntax (`.feature` files) to ensure they are readable by both technical and non-technical stakeholders.
* **Page Object Model (POM):** UI elements (locators) and page-specific methods are strictly separated from test scripts. Each web page has its own corresponding Class, making the code highly reusable and easy to maintain.
* **Singleton Design Pattern:** A custom `Driver` class is implemented to ensure that a single WebDriver instance is shared across the entire test execution session.
* **Data-Driven Configuration:** Environment variables (e.g., browser type, base URL) are managed externally via a `configuration.properties` file and a `ConfigReader` utility.

## ✨ Key Features & Optimizations
* **Ad-Bypass Strategy:** Integrated custom `JavascriptExecutor` methods to forcefully bypass dynamic Google Vignette (full-page) iframes and pop-ups without causing `ElementClickInterceptedException`.
* **Explicit Waits & Scroll:** Intelligent waits and JS-based scrolling are implemented to handle elements that are dynamically loaded or hidden behind ad banners.
* **Hooks Management:** `@Before` and `@After` hooks are configured to manage test teardown and automatically capture **screenshots** for any failed scenario.
* **Optimized Page Load:** Configured `PageLoadStrategy.EAGER` and disabled Chrome autofill/notifications to drastically reduce test execution time.

## 📋 Implemented Test Scenarios (Execution Syntax)

* **Login:** Positive and Negative login scenarios.

* **Register:** End-to-End user registration and existing email validation.

* **Logout:** Secure user logout and redirection verification.

* **Contact Us:** Form submission, JS Alert handling, and safe redirection.

* **Test Cases:** Navigation and visibility verification.

* **Products:** All Products listing and individual Product Detail verification.


## ⚙️ How to Run the Tests
You can execute the test suite using the JUnit TestRunner class located in src/test/java/runners/TestRunner.java.
To run specific test scenarios, update the tags parameter within the @CucumberOptions annotation:

```text
tags = "@smoke"      // Runs smoke/login test
tags = "@register"   // Runs registration test
tags = "@logout"   // Runs logout test
tags = "@contactus"   // Runs contact test
tags = "negative_login"   // Runs invalid login test

//These are the example cases. For more, please take a look at the
//"TestRunner" class and the feature files for all available tags.
```
Alternatively, run tests via Maven command line:

```bash
mvn clean test -Dcucumber.options="--tags @smoke"
```

## 📂 Project Structure
```text
AutomationExerciseBDD/
├── src/
│   └── test/
│       ├── java/
│       │   ├── hooks/             # Setup and Teardown methods (Screenshots on fail)
│       │   ├── pages/             # Page Object Classes (Locators & WebElements)
│       │   ├── runners/           # JUnit TestRunner class
│       │   ├── stepdefinitions/   # Java implementation of Gherkin steps
│       │   └── utilities/         # Singleton Driver, ConfigReader, Reusable JS Methods
│       └── resources/
│           ├── features/          # Cucumber Gherkin (.feature) files
│           └── configuration.properties # Global test configurations
└── pom.xml                        # Maven dependencies and build configuration
