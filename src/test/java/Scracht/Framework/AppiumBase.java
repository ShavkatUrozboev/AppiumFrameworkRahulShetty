package Scracht.Framework;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a_PS_30");
        options.setNoReset(true);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
    public void longClickGesture(WebElement element, int duration) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", duration
        ));
        //duration default: 500, like: 2000
    }
    public void doubleClickGesture(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }
    public void clickGesture(WebElement element, int endX, int endY) {
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
    public void dragGesture(WebElement element, int endX, int endY) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
    public void flingGesture(WebElement element,String direction,int speed) {
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "speed", speed
        ));
        //direction: up, down, left and right
        //speed: min(default) = 175 ,pixels/second, 7500 * displayDensity
    }
    public void pinchOpenGesture(WebElement element,double percent,int speed) {
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent,
                "speed",speed
        ));
        //percent:  0.00 - 1.00
        //speed: 2500 * displayDensity
    }
    public void pinchCloseGesture(WebElement element,double percent,int speed) {
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", percent,
                "speed",speed
        ));
        //percent:  0.00 - 1.00
        //speed: 2500 * displayDensity
    }
    public void swipeGesture(WebElement element, String direction, double percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percent
        ));
        //direction: up,down,left,right.
        //percent: 0.00 - 1.00 , 0.75
    }
    public void scrollTimeGesture(int time) {
        for (int i = 0; i < time; i++) {
            boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100,
                    "top", 100,
                    "width", 200,
                    "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }
    }
    public void scrollEndGesture(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100,
                    "top", 100,
                    "width", 200,
                    "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
//        Thread.sleep(2000);
    }
    public void scrollTextGesture(String text) {
        driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }
}
