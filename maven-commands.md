## How to start Test
```
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/test-suites/Regression.xml

```

## 
```
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/test-suites/Regression.xml -DbaseUrl=http://demowebshop.tricentis.com

```

## Supply env variables
### From IDE
```
 System.env("baseUrl");
```

### From maven commandline
```
 System.getProperty("baseUrl");
```
