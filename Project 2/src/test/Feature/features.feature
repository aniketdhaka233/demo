Feature: Test grid


  Scenario: test login to gridpoint
     Given Open Chrome and start Application
     Then I verify the login page
    When I enter a username and password
    Then I verify the we have succesfully logged in


  Scenario: verify the comm tool
    Then go to Configuration tab and verify template is visible
    Then enter the site and select the site
    Then click on configuration module and click on use control config
    Then Verify the Page by checking General Tab and quit
