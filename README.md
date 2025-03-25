# Java API Automation Framework

This repository contains a robust API automation testing framework built using Java. It leverages industry-standard libraries and tools to provide a scalable, maintainable, and efficient solution for testing RESTful APIs.

## Features
- **REST API Testing**: Comprehensive testing of RESTful services
- **Modular Design**: Well-structured and reusable code architecture
- **Detailed Reporting**: Beautiful test reports with screenshots and logs
- **Data-Driven Testing**: Support for Excel-based test data
- **JSON Handling**: Easy JSON parsing and manipulation
- **Logging**: Detailed execution logs for debugging

## Tech Stack
- **Java**: Core programming language
- **Rest Assured**: API testing library
- **TestNG**: Test framework and execution engine
- **AssertJ**: Fluent assertions library
- **Apache POI**: Excel file handling for data-driven testing
- **Allure Reports**: Test reporting framework
- **Log4j**: Logging framework
- **Gson**: JSON processing library
- **Maven**: Dependency management and build tool

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6.0 or higher
- IDE (IntelliJ IDEA or Eclipse recommended)
- Git

## Setup Instructions
1. Clone the repository:
```bash
git clone https://github.com/your-username/repository-name.git
```

2. Navigate to the project directory:
```bash
cd repository-name
```

3. Install dependencies:
```bash
mvn clean install
```

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── api/              # API client classes
│   │   ├── config/           # Configuration classes
│   │   ├── utils/            # Utility classes
│   └── resources/            # Configuration files and properties
└── test/
    ├── java/
    │   ├── tests/            # Test classes
    │   ├── data/             # Test data handling
    └── resources/            # Test-specific resources
```

## Running Tests
Execute all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=TestClassName
```

Generate Allure report:
```bash
mvn allure:report
```

## Configuration
- `config.properties`: Main configuration file
- `log4j2.xml`: Logging configuration
- `testdata.xlsx`: Test data Excel file

## Maven Dependencies
```xml
<dependencies>
    <!-- Rest Assured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.4.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
    
    <!-- AssertJ -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.24.2</version>
    </dependency>
    
    <!-- Apache POI -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>5.2.5</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.5</version>
    </dependency>
    
    <!-- Allure -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.25.0</version>
    </dependency>
    
    <!-- Log4j -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.20.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.20.0</version>
    </dependency>
    
    <!-- Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
```

## Contributing
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Contact
Your Name - Shubham Sharma/Shubhamss23.1993@gmail.com

Project Link: https://github.com/Shubhamsep2317/APIAutomationFrameworkATB10x

This README provides a clear overview of your project, setup instructions, and usage guidelines that will help other developers understand and use your framework effectively.
