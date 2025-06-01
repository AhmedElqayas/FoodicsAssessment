Feature: Purchase Products

  @test
  Scenario: Purchase video games related products with price below 15k EGP
    Given the user goes to home page
    And the user login with "01093620399" and "Ahmedqayas123;"
    And the user goes to all video games page
    When the user apply some filters
    And the user selects items with price lower that "15000"
    And the user goes cart
    Then all items should be added successfully
    When the user goes to buy page
    And the user adds address
    Then total amount should be correct