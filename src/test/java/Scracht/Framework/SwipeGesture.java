package Scracht.Framework;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeGesture extends AppiumBase {
    @Test
    public void SwipeGestureTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "true");
        swipeGesture(firstImage, "left", 0.75);
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"), "false");
    }
}
