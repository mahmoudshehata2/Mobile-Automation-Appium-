package org.example.StepDefinetions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TC02_AddToCart {

    @When("User add product to cart Using Scroll")
    public void AddToCart() throws InterruptedException {
        // all product have the same id   op : 2
        System.out.println( Hook.driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size());
        Thread.sleep(3000);
 //
        String radioGroup = "new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\").instance(0))";
        Hook.driver.findElement(MobileBy.AndroidUIAutomator(radioGroup)).click();

        Thread.sleep(2000);

        int count = Hook.driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int x=0 ; x<count ;x++)
        {
            MobileElement w = (MobileElement) Hook.driver.findElements(MobileBy
                    .id("com.androidsample.generalstore:id/productName")).get(x);
            String text = w.getText();
            System.out.println(text);

            if (text.equals("Jordan 6 Rings")){
                Hook.driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
                Thread.sleep(2000);
                break;
                // findelemnts  doesn’t work       getText doesn’t work
                //Hook.driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(x).getText()
            }
        }
         // outside if and for
        Hook.driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
         Thread.sleep(2000);
    }

    @Then("Validate user Add product to Cart successfully")
    public void validateUserAddProductToCartSuccessfully() {

        String text = Hook.driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
        System.out.println("Text Assertion :"+text);

        Assert.assertEquals(text,"Jordan 6 Rings");



    }
}