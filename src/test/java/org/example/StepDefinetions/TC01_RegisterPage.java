package org.example.StepDefinetions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC01_RegisterPage {

    WebDriver driver ;

    public TC01_RegisterPage() {

        this.driver = Hook.driver;
    }
       public AndroidTouchAction action ;
    @Given("user select the country Using SCROLL")
    public void user_select_country() throws InterruptedException {

        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //String title = driver.getTitle();
        //System.out.println(driver.getTitle());
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
/*
         Note : This way is working but i need to use scroll in mobile
        List<WebElement> dropDownList = driver.findElements(By.id("android:id/text1"));
        dropDownList.get(3).click();
 */
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new    UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Angola\").instance(0))")).click();

     //   AndroidElement element = (AndroidElement)driver.findElement(MobileBy.AccessibilityId(""))

            //    action = new AndroidTouchAction((PerformsTouchActions) driver);

        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Angola\").instance(0))";
        driver.findElement(MobileBy.AndroidUIAutomator(scrollElement)).click();


      //  driver.findElementByAndroidUIAutomator(scrollElement).click();




    }



/*
not used this way  TAU
        Dimension  dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd =(int) (dimension.getHeight() * 0.1);
        action = new AndroidTouchAction((PerformsTouchActions) driver).press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();

        AndroidElement dropDownList = driver.findElement(MobileBy.linkText("Angola"));
        action.tap(ElementOption.element(dropDownList)).perform();


 */




    @When("user enter name{string}")
    public void userEnterName(String arg0) {
           driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys(arg0);// name
    }

    @And("user select gender and click button Let’s shop")
    public void userSelectGender() throws InterruptedException {



        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isSelected();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();


        /*
       // driver.findElement(By.className("android.widget.TextView"));
        List radio = driver.findElements(By.className("android.widget.TextView"));

        boolean bval = false;        // create a variable which will have boolean value True/False
        bval = radio.get(0)    // will return True if button is selected.

        if(bval = true)
        {
            radio.get(1).click(); // if the first radio button is selected by default, this will select Second radio button
        }
        else
        {
            radio.get(0).click(); // if the first radio button is not selected by default, the first will be selected
        }
        Boolean is_selected = list.get(0)



        String str = driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isSelected();  //.getAttribute("checked");
        if (str.equalsIgnoreCase("true"))
        {
            System.out.println("Checkbox selected");
        }

         */



    }

    @Then("user register successfully")
    public void userRegisterSuccessfully() throws InterruptedException {

        AndroidElement titel =  driver.findElement(By.id("com.androidsample.generalstore:id/rvProductList"));

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(titel));    //title:  Products

    }


    @Then("user register could not register appear for User Toast \\(Error)Message")
    public void AppearForUserToastErrorMessage() throws InterruptedException {

        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"); //
        System.out.println(toastMessage); //error message :  Please enter your name


         Assert.assertEquals(toastMessage,"Please enter your name");


    }
}

