
  Feature: F04_Mobile_Gestures | Validate pricing |checkbox | Long Press | Navigate to WebView (ex: google)

    Scenario: User able to use long Press and   correctly
      Given user select the country Using SCROLL
      When user enter name"MawdaMH"
      And user select gender and click button Let’s shop
      And User add TWO product to cart
      Then Validate pricing and total
      And User select checkbox successfully
      And User use Long Press to open Terms and condition message and close the message condition
      And User Navigate to WebView Successfully