
  Feature: F03_Total_Purchase_Amount   | Check Price

    Scenario: Validate user able to purchase amount successfully
      Given user select the country Using SCROLL
      When user enter name"Rana"
      And user select gender and click button Let’s shop
      And User add TWO product to cart
      Then Validate Total Purchase Amount is corrected