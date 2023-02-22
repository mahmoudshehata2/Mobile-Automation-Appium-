package org.example.StepDefinetions;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook {
   // AppiumDriver
    public static AndroidDriver driver = null;


    @Before
    public static void openMobileApp() throws MalformedURLException {
        DesiredCapabilities capab = new DesiredCapabilities();
        capab.setCapability("platformName","Android");
        capab.setCapability("automationName","UiAutomator2");
        capab.setCapability("platformVersion","8.0");
        capab.setCapability("deviceName","Android Emulator");
        capab.setCapability("appPackage","com.androidsample.generalstore");
        capab.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
       // capab.setCapability("browserName","Chrome");

    //   WebDriverManager.chromedriver().setup();
      //  capab.setCapability("chromedriverExecutable",WebDriverManager.chromedriver().getBinaryPath());
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),capab);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //driver.get("https://google.com");
    }
     @After
    public static void close_Appium_driver()
    {
           if(null != driver){
               driver.quit();
           }
    }
}
