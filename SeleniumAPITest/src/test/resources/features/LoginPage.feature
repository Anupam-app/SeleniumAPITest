Feature: Navigate to Retool page "https://retool.com/api-generator"

  Scenario: Check the Retool Page
    Given User navigate to "https://retool.com/api-generator"
    And validate page title "REST API Generator"
    When User give the column title "Name"

