Feature: Test Reqres user api with rest assured and cucumber BDD framework

Scenario: Reqres GET API test
    Given the valid endpoint to fetch users
    When the request is send to server
    Then validate the response of the list of users
  Scenario Outline: Reqres GET Single User
    Given the valid endpoint to fetch user
    When the request is send to get the single user
    Then validate the response of single user by first_name as "<first_name>" email as "<email>" status_code as <status_code>

    Examples: 
      | first_name | email                  | status_code |
      | Janet      | janet.weaver@reqres.in |         200 |

  Scenario Outline: Reqres GET Single User Not Found test
    Given the valid endpoint to find user
    When the request of single user not Found is send to server
    Then validate the response by status_code as <status_code>

    Examples: 
      | status_code |
      |         404 |
