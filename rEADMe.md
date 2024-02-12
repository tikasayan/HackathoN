##Project Overview
 
This Selenium automation testing project focuses on automating tasks related to the Coursera website (https://www.coursera.org/en-IN).
The primary objectives include searching for Web Development Courses in search tab with English Language and Beginner Level criteria.
Extract all the languages available in the Languages tab and displaying all the languages in the console.
Next Search for Language Learning course in search tab and also displaying all the languages available in Language Learning Courses.
Last Step includes navigating back to coursera homepage and click on Coursera for campus under solution tab.
Fill the form which is coming in that webpage and fill with one invalid input(such as put invalid email).
The project uses various dependencies and libraries to facilitate automation.The whole project is developed using a framework which contains several page objects under which there are classes which describes the functionality of the program.
## Project Structure
 
### 1. Eclipse IDE
 
- ** IDE Version 2023-12 (4.30.0)
### 2. Maven Repository
 
- **Maven Version**: 3.12.1
 
### 3. Dependencies Used in POM.xml file
 
   3.1. Selenium-Java
       - Version: 4.15.0
   3.2  Apache-poi
       - Version: 5.2.2
   3.3  Log4j-Core
       - Version: 2.20.0
   3.4 TestNG
       - Version: 7.7.1
   3.5 ExtentReports
       - Version: 5.0.9
 
Usages of the Dependencies->
 
- **TestNG**
- Version: 7.7.1
- Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
- **Extent Report**
- Version: 5.0.9
- Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
- **Selenium**
- Version: 4.15.0
- Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
 
 
## Automation Test Flow
 
1. **Open Coursera Home Page & Search for 'Web Development Course'**
- Go to search tab of the homepage and Search for 'Web Development Courses'.
 
2. **Apply the criteria **
- Click on checkbox 'Beginner' under level.
- Click on checkbox 'English' under language selection.
- Display the total web development courses with the applied criteria.
- Pick up the first two courses among them.
- Display the first two courses' Name, rating and course duration in the console.
- Click on show more option under languages.
- Extract all the languages with their counts.
 
3. ** Search for 'Language Learning' in the search tab**
 
- Extract and display 4 levels of 'Language Learning' course in console.
- Display all the languages available in Language Learning.
- Print all the languages under Language Learning courses.
 
 
4. ** Now Navigate to cousera home page and go to For Enterprise **
 
- Go to For Enterprise tab of coursera webpage
- Click on Solution
- Click on Coursera for Campus under university option
- Click on Contact Sales
 
5. ** Fill the Form opening with invalid input**
 
- Fill the form with First Name, Last Name, Phone number, Work Emailid, Institution type, Institution name, Job Role and Department.
- Put any invalid input(Such as put invalid email-id).
- Capture the error screenshot and Display the error message in console.
 
6. ** Capture Screenshots of Each Page with each options opening.
 
- Generate all the screenshots in the Screenshots folder.
- Display screenshots of 'Search result for Web Development', Coursera home page
 
 
7. ** Generate Extent Report **
 
- Generate Extent Report with name myReport.html which contains Pass/Fail status of all the methods in the Test Cases.
- 13 events and 13 tests have been passed in my extent report.
- Show all the results
 
8. ***Create SeleniumGrid **
 
-  Create a localhost in Selenium using grid
-  Download and install selenium-server-4.17.0.jar file and run the grid code using cmd
-  Run the code in remote environment by setting execution_env to 'remote'
   in config.properties file
 
9.  ** Use Jenkins **
  
- Download and install jenkins.war file
- Run it through command prompt(cmd) using command ->  C:\Users\2303498\Jenkins>java -jar jenkins.war
- Create account in Jenkins and login
- Show the activity in dashboard in portal jenkinhttp://localhost:8080
 
10. ** Push the code in Git Repository **
 
- Register and create an account in GitHub
- Push the Code to GitHub Repository
 
## Test Cases -->>
 
  1. TC001_SearchHomePage.java - This test case checks whether correct homepage of coursera.org opened or not.
  2. TC002_WebDevelopmentPage.java - This test case uses methods to check level select and languages checking of Web development course.
  3. TC003_LanguageLearning.java - This test case uses methods to check all the levels of the language learning course and all the respective languages.
  4. TC004_BussinessCoursera.java - This test case checks whether 'contact us' page opened or not and this also captures the 'error message' appeared after invalid input in Form-Fill page.
 
 
## How to Run the Tests
1. **Open Eclipse IDE:**
- Launch Eclipse IDE on your machine.
 
2. **Import Project:**
- Select 'File' -> 'Import' from the menu.
- Choose 'Existing Maven Projects' and click 'Next'.
- Browse to the directory where you cloned the repository and select the project.
 
3. **Update Maven Project:**
- Right-click on the project in the Project Explorer.
- Choose 'Maven' -> 'Update Project'.
- Click 'OK' to update dependencies.
 
4. **Run Test Suite:**
- Locate the test suite file (e.g. 'src/test/java/TestSuite.java').
- Right-click on the file and choose 'Run As' -> 'TestNG Suite'.
 
5. **View Reports:**
- After execution, open the 'report' folder.
- Find the Extent Report HTML file ('myReport.html') for detailed test reports.
 
## Author Information
 
- **Sayantika Dholey**
 
 
## Disclaimer
This project is intended for educational and testing purposes only. The author is not responsible for any unauthorized use or modification of the code. Use at your own risk.

