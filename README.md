# BDD_Cucumber_Dummy_Framework

## _Introduction_ 
- nopCommerce is an dummy eCommerce shopping website. 
- In the project, we will use a Hybrid Framework built using Maven, Java, Selenium, Gherkin, Cucumber(5.7.0), JUnit, Extent-Report and POM concept .
- In the Login test, we have used @FindBy to store WebElements in the Page Object Model and have created test using Feature and StepDefinition.
- In the Customers test, we have used both @FindBy and By class with findElement(s) in different scenarios, to store WebElements in the Page Object Model and have also used WebDriverWait and have created test using Feature and StepDefinition.
- We have added extent.properties and spark-config.xml by referring to (https://github.com/grasshopper7/extentreports-cucumber5-adapter)

## _Getting Started_
To get started we need to perform the following steps:
1. We should have Eclipse Version: 2021-06 (4.20) installed.
2. We should have Java Version 11 installed.
3. We should have Chrome browser Version 120.0.6099.130 or above. Please update drivers folder with respect to chrome version.
4. The other dependencies will be handled from the pom.xml file itself.

## _Dependencies_
1. maven-compiler-plugin : Version 3.8.11
2. maven-surefire-plugin : Version 3.0.0-M5
3. java: Version 11
4. selenium-java: Version 3.141.59
5. junit: Version 4.13
6. cucumber-core: Version 5.7.0
7. cucumber-java: Version 5.7.0
8. cucumber-junit: Version 5.7.0
9. apiguardian-api: Version 1.1.0
10. cucumber-html: Version 0.2.7
11. cucumber-jvm-deps: Version 1.0.6
12. cucumber-reporting: Version 5.3.0
13. commons-io: Version 2.6
14. commons-lang3: Version 3.9
15. gherkin: Version 12.0.0
16. messages: Version 11.1.1
17. mocito-core: Version 3.12.4
18. guava: Version 30.0-jre
19. extentreports-cucumber5-adapter: Version 2.17.0

## _Scenarios_
1. Successful Login with Valid Credentials
2. Validate Login with Data Driven concept
3. Add a new Customer
4. Search Customer by EmailId
5. Search Customer by Name

## _Build and Test_
1. Import the .project in Eclipse as a maven project.
2. Check all dependencies are downloaded and no error is shown.
3. We can run the test in two ways either as JUnit test or as a Maven Test
    - To run as a JUnit test, open TestRun class from testRunner package,
        ```bash
         TestRun.class-> Right Click -> Run As -> JUnit Test.
        ```
    - To run as Maven test,
        ```bash
         pom.xml-> Right Click -> Run As -> Maven Test.
        ```
    
4. After the execution is completed the test report can be seen as
    - For the JUnit test report, go to 
        ```bash
         test-output -> Right-click on index.html -> Open with WebBrowser
        ```
    - For Extent report, go to
        ```bash
         report-> SparkReport -> Right-click on CucumberExtentReport.html -> Open with WebBrowser
        ```

## _Contributions_

- Framework and Automation Test - Bhaskar (bhaskarreborn@gmail.com)

## _Authors_

- [@bhaskar](https://github.com/Draculareborn)

## _🔗 Links_

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/bhaskarqa/)

## _Reference_

- [@SDET- QA - Mr. Pavan](https://www.youtube.com/channel/UC46vj6mN-6kZm5RYWWqebsg)

