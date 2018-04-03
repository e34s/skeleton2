
## Allure TestNG Example

### Getting Started

To run all tests:

```mvn clean test``` 

To run a specific test class: 
```mvn -Dtest=ClassName test```


To generate Allure Report:

```bash
$ ./mvnw clean test site
```

The report will be generated to `target/site/allure-maven-plugin` folder. To open the report use the following command:

```bash
$ ./mvnw io.qameta.allure:allure-maven:serve
```

## Known issues / TODOs

- add test with excel sheet data provider 
- figure out how to generate report without mavenw (wrapper) 
- change code so that test classes don't need to end with xyzTest
- check if :serve needs to be called with each test run or if it can be used in auto refresh mode 
- attach screenshot to report 
