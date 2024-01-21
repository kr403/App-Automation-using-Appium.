package tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testCases extends BaseClass{

    @Test
    public void loginApp(){
        driver.findElement(By.id("net.omobio.robisc:id/edit_text")).sendKeys("01849010633");
        driver.findElement(By.id("net.omobio.robisc:id/button_request_otp")).click();
        driver.findElement(By.id("net.omobio.robisc:id/code1")).sendKeys("4");
        driver.findElement(By.id("net.omobio.robisc:id/code2")).sendKeys("0");
        driver.findElement(By.id("net.omobio.robisc:id/code3")).sendKeys("1");
        driver.findElement(By.id("net.omobio.robisc:id/code4")).sendKeys("5");
        driver.findElement(By.id("net.omobio.robisc:id/code5")).sendKeys("0");
        driver.findElement(By.id("net.omobio.robisc:id/code6")).sendKeys("0");
        driver.findElement(By.id("net.omobio.robisc:id/button_continue_login")).click();
    }
}
