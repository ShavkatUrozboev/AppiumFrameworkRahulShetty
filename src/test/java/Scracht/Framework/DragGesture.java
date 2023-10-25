package Scracht.Framework;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragGesture extends AppiumBase{
    @Test
    public void DragGestureTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragGesture(source,619,560);

        Thread.sleep(3000);
        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");

    }
}
