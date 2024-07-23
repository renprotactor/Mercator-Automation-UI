
## Mercator Automation Exercise

## Overview

This repository contains an exercise for Mercator, implemented using the Page Object Model (POM) design pattern.

### Project Structure
__BasePage__: src/test/java/mercator/driver/BasePage.java

This is where the Chromedriver is instantiated.

__Pages__: src/test/java/mercator/pages/*.java
All the page objects are defined here.

__Runner__: src/test/java/mercator/runner/Runner.java
This file is used to run the scenarios. The step definition paths are specified in the glue option.

__Steps__: src/test/java/mercator/steps/AutomationPracticeSteps.java
All the Cucumber step definitions are located in this file.

__Properties__: src/test/resources/properties/test.properties
All the configuration properties, such as host and timeouts, are defined here.

__Reports__: Both cucumber-html report and extend reports are generated in the path, as below.

		cucumber-html report :  C:\Automation\mercator-automationtest-ui\target\cucumber-html-reports

		extent-report : 	\test-output\Html\ExtentHtml.html




### How to Run the Tests
You can run these tests on both Windows and Mac. The tests are executed using the Runner.java file, and tags are already defined within it.

__Using an IDE__

Right-click on the Runner.java file.
Select "Run".

__Using Terminal__

Navigate to the project folder:
cd {projectFolder}

Compile the project:
mvn compile

Run the tests:
mvn test
