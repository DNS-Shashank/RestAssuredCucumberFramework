Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<Address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created to "<name>" using "GetPlaceAPI"


Examples:
    | name       | language      | Address              |
    | DNSS House | Telugu        | Chinamaya Nagar, Atp |
#    |Shan House | Sanskrit      | Ferror Nagar, Atp    |


@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When user calls "DeletePlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"