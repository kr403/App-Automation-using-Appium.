package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeTest
    public void setup(){

        try {
            service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\khali\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 6 API 34");
            options.setApp("C:\\Users\\khali\\IdeaProjects\\SingleAppMyRobi\\src\\test\\resources\\apps\\My Robi_6.2.5.apk");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception exp){
            System.out.println("Cause is : "+exp.getCause());
            System.out.println("Message is :"+exp.getMessage());
            exp.printStackTrace();
        }

    }

//    @AfterTest
//    public void teardown(){
//        driver.quit();
//        service.stop();
//    }
}