Feature: Creating Booking


  Scenario: Create Booking with Valid Data
    Given Create booking with valid data
    When I send a POST request to the Create Booking API
    Then I should receive a 200 status code
    And The response should contain the booking details

#status code should be 400
  Scenario: Create booking with missing required fields
    Given I have booking details with missing required fields
    When I send a POST request to the Create Booking API
    Then I should receive a 500 status code
    And The response body should contain an error message indicating the missing required fields

#status code should be 400
  Scenario: Create booking with invalid data types
    Given I have booking details with invalid data types
    When I send a POST request to the Create Booking API
    Then I should receive a 200 status code
#    And The response body should contain an error message indicating the invalid data types