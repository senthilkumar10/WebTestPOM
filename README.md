
# WebTestPOM

E2E Web Automated Test using Selenium

# Key features of this Framework

This Framework is designed based on Page Object Model which would help to keep the Page Objects and Test Cases separate for easy maintenance.

Generate random meaningful user test data using JFairy API

Test data Driven – Read Test data from Excel using Apache POI and TestNG Data Provider annotation. All test data required is placed in "TestData" folder which is available in src

Logs are generated from TestNG & WebDriverEvent Listners using log4j and all the logs are stored in TestResults Folder

Based on the OS, appropriate driver files are loaded [Window, MAC]. Path for browser is provided by OsPath.java class inside com.gfk.web_test.util package.

Extent Reports are generated for every execution in ‘TestResults’ folder with the meaning steps details alongside screenshots

Browser and URLs are possible to configure in Config.Properties

Supports Parallel Execution 
