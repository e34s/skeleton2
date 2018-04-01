
## Allure TestNG Example

### Getting Started

To run all tests:

```mvn clean test``` 


To generate Allure Report:

```bash
$ ./mvnw clean test site
```

The report will be generated to `target/site/allure-maven-plugin` folder. To open the report you can use the following command:

```bash
$ ./mvnw io.qameta.allure:allure-maven:serve
```

## Known issues / TODOs

- figure out how to generate report without mavenw (wrapper) 
- change code so that test classes don't need to end with xyzTest



### More

* [Documentation](https://docs.qameta.io/allure/2.0/)
* [Issue Tracking](https://github.com/allure-framework/allure2/issues?labels=&milestone=&page=1&state=open)
* Gitter chat room: [https://gitter.im/allure-framework/allure-core](https://gitter.im/allure-framework/allure-core)
* StackOverflow tag: [Allure](http://stackoverflow.com/questions/tagged/allure)
