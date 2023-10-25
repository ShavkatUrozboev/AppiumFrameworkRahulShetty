package Scracht.Framework;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollGesture extends AppiumBase{
    @Test
    public void ScrollGestureTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //where to scroll is known prior
        scrollTextGesture("Hi");

        //No prior idea
        scrollEndGesture();

        scrollTimeGesture(10);
    }
}
