package org.example.StepDefinetions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class TC04_Gestures_LongPress {

    @Then("Validate pricing and total")
    public void Validate_pricing_total() {

        int count = Hook.driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

        double sum =0 ;
        for (int c=0 ; c<count ;c++){        // loop for another product and add in price 1

            MobileElement p1 = (MobileElement) Hook.driver.findElements(MobileBy
                    .id("com.androidsample.generalstore:id/productPrice")).get(c);
            String price1 = p1.getText();

            double totalAmount = getAmount(price1);
            sum = sum + totalAmount ;

        }

        System.out.println("TotalPrice = "+sum);

        // LOCATE total   $280.97          // actual result
        MobileElement t = (MobileElement) Hook.driver.findElement(MobileBy
                .id("com.androidsample.generalstore:id/totalAmountLbl"));
        String tP = t.getText();

        tP = tP.substring(1);
        double TotalPayment =Double.parseDouble(tP);
        System.out.println("TotalPayment= "+ TotalPayment);


        Assert.assertEquals(TotalPayment,sum); // (actual , Expected)
    }

          public static double getAmount(String value)
          {
              value = value.substring(1);
              double price2 = Double.parseDouble(value);

              return price2;
          }


    @And("User select checkbox successfully")
    public void userSelectCheckboxSuccessfully() throws InterruptedException {

       WebElement checkbox = Hook.driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction c = new TouchAction(Hook.driver);
        c.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();

        Thread.sleep(1000);
    }

    @And("User use Long Press to open Terms and condition message and close the message condition")
    public void userUseLongPressToOpenTermsAndConditionMessage() {
    WebElement long_Press_Action =
            Hook.driver.findElement(By.xpath("//*[@text ='Please read our terms of conditions']"));

        TouchAction l = new TouchAction(Hook.driver);
      l.longPress(LongPressOptions.longPressOptions()
             .withElement(ElementOption.element(long_Press_Action))
              .withDuration(Duration.ofSeconds(2))).release().perform();

        Hook.driver.findElement(By.id("android:id/button1")).click();

    }

    @And("User Navigate to WebView Successfully")
    public void userNavigateToWebViewSuccessfully() throws InterruptedException {
        Hook.driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(4000);
        //Hook.driver.findElement(MobileBy.AccessibilityId("com.androidsample.generalstore:id/btnProceed")).click();

    }
}
