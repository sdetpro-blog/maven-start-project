## Command to start Hub
```

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