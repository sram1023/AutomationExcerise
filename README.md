Employee API Automation
-------------------------

This framework has been developed using below tech stack and covered POST, GET, PUT, and DELETE services. Junit assertions are used to validate responses.

Tech Stack
-----------
Cucumber : 7.10.1
Java : 17
rest-assured : 5.5.0
Junit : 4.13.2
lombok : 1.18.34
maven : 3.9

Steps to Run the Feature File in local machine:
-----------------------------------------------

1.Clone the repo : git clone https://github.com/sram1023/AutomationExercise.git

2.Step into right directory path : cd AutomationExercise

3.mvn clean test -Dcucumber.filter.tags=@Employee

Note: 
1.Please use the right tag names to run specific scenario

2.You may frequently encounter a 429 Too Many Requests response for all the APIs due to rate limiting. To avoid this issue, please run each method separately by commenting out the other steps in the feature file while running.

Report
------
We can see the cucumber io report by default after execution in the console

Sample link : https://reports.cucumber.io/reports/e4d368e0-4623-4164-85a5-470a76c77bf9
