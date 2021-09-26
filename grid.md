# What is it
. Generally speaking, cross-browser testing is technique that you need to handle to 
    have your test methods able to run on different browser types, environments in parallel.

. You CAN'T combine dataPovider and Parameters annotation from TestNG same time!

. You need to design your test suite to have important test scripts to run cross-browser testing.
    It's not necessary to have all test methods to run cross-browser testing.
    
## Command to start Hub
```
java -jar /path/to/selenium-server-file -role hub
```

## Command to start Node
This node will register:
* Chrome
* Firefox
* Safari

Note: IF you are on Windows OS, please remove part related to safari and add for Edge
```
java -jar -Dwebdriver.gecko.driver=/Users/tuhuynh/SOURCE_CODE/maven-start-project/selenium-grid/geckodriver -Dwebdriver.chrome.driver=/Users/tuhuynh/SOURCE_CODE/maven-start-project/selenium-grid/chromedriver /Users/tuhuynh/SOURCE_CODE/maven-start-project/selenium-grid/selenium-server-standalone-3.141.59.jar -role node -nodeConfig /Users/tuhuynh/SOURCE_CODE/maven-start-project/selenium-grid/node_config.json

```