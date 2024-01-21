package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class testCases extends BaseClass{

    @Test
    public void listOfModules(){
        System.out.println("Starting login module.");
        login();
        System.out.println("Starting handlePermission module.");
        handlePermission();
        System.out.println("Starting handlePopUp module.");
        handlePopUp();
        System.out.println("Starting signOut module.");
        signOut();
    }

    public void login(){
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

    public void handlePermission(){
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        } catch (Exception e) {
            System.out.println("Exception caught while handling device's location permission: " + e.getMessage());
        }
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            } catch (Exception e) {
            System.out.println("Exception caught while handling contacts permission: " + e.getMessage());
        }
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
            } catch (Exception e) {
            System.out.println("Exception caught while handling notifications permission: " + e.getMessage());
        }
        try {
            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        } catch (Exception e) {
            System.out.println("Exception caught while handling manage phone calls permission: " + e.getMessage());
        }
    }

    public void handlePopUp(){
        try {
            driver.findElement(By.id("net.omobio.robisc:id/cross")).click();
        } catch (Exception e) {
            System.out.println("Exception caught while handling VoLTE PopUp: " + e.getMessage());
            try {
                driver.findElement(By.id("net.omobio.robisc:id/buttonClose")).click();
            }catch (Exception ex){
                System.out.println("Exception caught while handling EasyPlan PopUp: " + ex.getMessage());
            }
        }
        try {
            driver.findElement(By.id("net.omobio.robisc:id/buttonClose")).click();
        } catch (Exception e) {
            System.out.println("Exception caught while handling EasyPlan PopUp: " + e.getMessage());
            try {
                driver.findElement(By.id("net.omobio.robisc:id/cross")).click();
            }catch (Exception ex){
                System.out.println("Exception caught while handling VoLTE PopUp: " + e.getMessage());
            }
        }
    }

    public void signOut(){
        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"net.omobio.robisc:id/navViewDashboard\"]/android.widget.LinearLayout/android.widget.LinearLayout[5]")).click();
        driver.findElement(By.id("net.omobio.robisc:id/buttonSignOut")).click();
    }



}
