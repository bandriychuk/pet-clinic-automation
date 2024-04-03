
# Pet Clinic Automation BDD

This test project based on [spring-petclinic-rest project](https://github.com/spring-petclinic/spring-petclinic-rest).

Before start:
 - Make sure you have the java 11 version installed
 - [spring-petclinic-rest project](https://github.com/spring-petclinic/spring-petclinic-rest) cloned on you local machine and Running petclinic locally.
  


## 🛠 Tools
- Java 11 
- Spring 
- Cucumber 
- RestAsshured 
- Junit 5
- Allure Report 
- Gradle


##  Project Structure
  - assertions
  - conditions


  - models:
    - payloads
    - responses


  - parameter
    - Custom ParameterTypes that extend standard ones: https://github.com/cucumber/cucumber-expressions#readme


  - services


  - state
    - General class to store runtime state across step definitions in one Scenario/Example. 
    - Can be autowired into step definitions class.


  - steps
    - described action steps
     
      

## Environment Variables

`ENV_NAME` - String value for launching tests on different environments

`LOGGING` - Boolean value for Turn on/off logging


## Features files

- Owner
- Users


## Run Locally

Clone the project

```bash
  git clone https://github.com/bandriychuk/pet-clinic-automation.git
```

Go to the project directory

```bash
  cd pet-clinic-automation
```



## Running Tests

To run tests, run the following command

```bash
  ./gradlew clean api-tests-bdd:test
```


## Allure Report
To generate Allure Report

```bash
  1 ./gradlew api-tests-bdd:downloadAllure
```
```bash
  2 ./gradlew api-tests-bdd:allureServe
```
![Screenshot 2024-04-04 at 01.01.09.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.01.09.png)

### Scenario

![Screenshot 2024-04-04 at 01.02.48.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.02.48.png)

#### Scenario Request/Response logging

##### Request
![Screenshot 2024-04-04 at 01.05.20.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.05.20.png)
![Screenshot 2024-04-04 at 01.04.55.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.04.55.png)

##### Response
![Screenshot 2024-04-04 at 01.06.20.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.06.20.png)
![Screenshot 2024-04-04 at 01.06.59.png](api-tests-bdd%2Fsrc%2Ftest%2Fresources%2FreadmeImages%2FScreenshot%202024-04-04%20at%2001.06.59.png)