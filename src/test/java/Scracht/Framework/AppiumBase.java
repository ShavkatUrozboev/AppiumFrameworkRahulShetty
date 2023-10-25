package Scracht.Framework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
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
        options.setAppPackage("com.iwon.client");
        options.setAppActivity("com.iwon.client.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
