@Employee
Feature: Employee API tests

  @CreateRecord
  Scenario: Create a employee record and validate the response
    When the rest api for post is ready
    Then validate the post response

  @GetRecord
  Scenario: Get the employee record and validate the response
    When the rest api for get is ready
    Then validate the get response

  @UpdateRecord
  Scenario: Update the employee record and validate the response
    When the rest api for put is ready
    Then validate the put response

  @DeleteRecord
  Scenario: Delete the employee record and validate the response
    When the rest api for delete is ready
    Then validate the delete response

