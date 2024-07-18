Feature: Employee API tests

  @Employee
  Scenario: Expose the CRUD operations for Employee APIs
    Given the rest api for post is ready
    Then validate the post response
    And the rest api for get is ready
    Then validate the get response
    And the rest api for put is ready
    Then validate the put response
    And the rest api for delete is ready
    Then validate the delete response
