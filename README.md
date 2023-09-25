# Juice shop Automation Tests

This is the juice shop test automation project.<br/>
There are several automation tests which checks basic functionality of the web shop.<br/>

<h1>System requirements</h1> 
Java 17, Gradle 8.1.1, chromedriver.<br/>
Project supports testing in Google Chrome.<br/>

<h1>Local run</h1>
1) Put appropriate chromedriver.exe into "chromedriver" folder of the root of the project.<br/>
2) For running all tests by IntelliJ IDEA: Launch `.run/RunCucumberTest.run.xml` run configuration.<br/>
                         by Gradle: gradlew :test --tests "io.cucumber.skeleton.RunCucumberTest" --stacktrace (Windows).<br/>
3) Test reports are available after test execution via RunCucumberTest.run.xml in the Run tab below test results.

<h1>Notes</h1>
*Browser type and path to appropriate driver is defined in test.properties file in the test resources.
*Previously created user with an existing account is defined in test.properties file in the test resources.


