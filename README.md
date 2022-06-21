# ClarkAssignmentTest

This repo consists of test cases created for this page : https://staging.clark.de/de/app/contracts?cv=2 using `Selenium, Junit and Cucumber`
It clicks on the recommendations page, fills the recommendation options, signs up, click to view recommendations and logs what is in view.

## Installation/Running the code
1. Have Java installed on your machine.

2. Clone the repo by first navigating to the the folder on your terminal that you want to create the project then run:
`git clone https://github.com/vindah/ClarkTestAutomation.git`

or clone directly on preferred IDE

3. Open project on preferred IDE(IntelliJ, Eclipse,VSCode, etc).

4. If dependencies are not updated, navigate to "pom.xml" file and sync the dependencies

5. Configure JUnit runner on your IDE and pass class name as "runner.testRunner"


### **To run Test in headless:**
1. Navigate to the driver factory file:
"src/main/java/utilities/driverFactory"
Scroll and find **options.addArguments("--headless");** and then remove comment.
Ensure to comment out/disable **options.addArguments("start-maximized");**

** This test currently runs in incognito.

2. To run via build run button, navigate to testRunner file in path:
"src/test/java/testRunner" and click on run or click on the run button beside Junit build configuration

3. To run via command prompt:
Navigate to root directory and run:
`mvn test`


### **To run Test in header**
1. Navigate to the driver factory file:
"src/main/java/utilities/driverFactory"
2. Ensure that **options.addArguments("start-maximized");** is active
3. Click on the JUnit build runner to run.




## Note:
The test was setup to run on local device but will be updated to also run on a server with Docker containers, as well as to use Visual testing.
