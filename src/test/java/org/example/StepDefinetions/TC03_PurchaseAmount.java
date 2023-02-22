package org.example.StepDefinetions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TC03_PurchaseAmount {


    @Given("User add TWO product to cart")
    public void add_product_cart() throws InterruptedException {
      //Hook.driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click(); not wo
        // All product have same index     first and second product
      Hook.driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
      Hook.driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();

        Hook.driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);

    }

    @Then("Validate Total Purchase Amount is corrected")
    public void validateTotalPurchaseAmountIsCorrected() {

        MobileElement p1 = (MobileElement) Hook.driver.findElements(MobileBy
                                                    .id("com.androidsample.generalstore:id/productPrice")).get(0);
        String price1 = p1.getText();   // $120.0     PRODUCT Name: Air Jordan 1 Mid SE
      //  System.out.println(price1);

        price1 = price1.substring(1);  // 120.0
        double value1 = Double.parseDouble(price1);


        MobileElement p2 = (MobileElement) Hook.driver.findElements(MobileBy
                                                   .id("com.androidsample.generalstore:id/productPrice")).get(1);
        String price2 = p2.getText();  //  $160.97

        price2 = price2.substring(1);   //160.97       PRODUCT Name: Air Jordan 4 Retro
        double value2 = Double.parseDouble(price2);

        double totalPrice = value1 + value2 ;            // totalPrice = 120.0 + 160.97
        System.out.println("TotalPrice = "+totalPrice); //280.97         // expected result


         // LOCATE total   $280.97
        MobileElement t = (MobileElement) Hook.driver.findElement(MobileBy
                .id("com.androidsample.generalstore:id/totalAmountLbl"));
        String tP = t.getText();

        tP = tP.substring(1);
        double TotalPayment =Double.parseDouble(tP);
        System.out.println("TotalPayment= "+ TotalPayment); // actual result




        Assert.assertEquals(TotalPayment,totalPrice);



    }
}
