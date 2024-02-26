Feature: Test localhost api with rest assured and cucumber BDD framework

  Scenario Outline: Localhost POST API test
    Given the valid endpoint to create user
    When the request is send to the server
    Then the new user will be created with name as "<firstName>" and validate reponse <status_code>

    Examples: 
      | firstName | status_code |
      | Shanni    |         201 |

  Scenario Outline: Localhost PUT API test
    Given the valid endpoint to update user
    When the put request is send to the server
    Then the user gets details validated with name as "<firstName>" and validate reponse <status_code>

    Examples: 
      | firstName | status_code |
      | Binu      |         200 |

  Scenario Outline: Localhost PATCH API test
    Given the valid endpoint to update user using patch service
    When the patch request is send to the server
    Then the user details gets updated and validated with name as "<lastName>" and validate reponse <status_code>

    Examples: 
      | lastName | status_code |
      | Joe      |         200 |

  Scenario Outline: Localhost DELETE API test
    Given the valid endpoint to delete user
    When the request is send to the server to delete data
    Then the user data will be deleted and validate reponse <status_code>

    Examples: 
      | status_code |
      |         404 |
