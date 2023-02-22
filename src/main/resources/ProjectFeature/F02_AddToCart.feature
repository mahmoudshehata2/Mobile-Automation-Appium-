
  Feature: F01_Add To Cart |  Add Products To Cart
    Scenario: User able to Add to Cart AND shop the items in APP Successfully
      Given user select the country Using SCROLL
      When user enter name"sdasd"
      And user select gender and click button Let’s shop
      And User add product to cart Using Scroll
      Then Validate user Add product to Cart successfully
