package Scracht.Framework;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MisceallanousAppiumActions extends AppiumBase {
    @Test
    public void AppiumTest(){
//        appPackage and appActivity
//        adb shell dumpsys window | grep -E 'mCurrentFocus'
        Activity activity =new Activity("io.appium.android.apis","io.appium.android.apis.ApiDemos");
        driver.startActivity(activity);

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//classname[@attribute='value']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();

        //
        DeviceRotation rotation=new DeviceRotation(0,0,90);
        driver.rotate(rotation);
        //

        driver.findElement(By.xpath("(//classname)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        //copy paste
        //copy to clipboard - paste it clipboard
        driver.setClipboardText("Hi Appium");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //

        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        //Android Buttons
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //
    }
}
