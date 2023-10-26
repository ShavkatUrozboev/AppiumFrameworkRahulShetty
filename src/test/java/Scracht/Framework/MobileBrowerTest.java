package Scracht.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowerTest extends AppiumBrowserBase{
    @Test
    public void MobileBrowser() throws InterruptedException {
//        driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");	//Scroll
        Thread.sleep(3000);
        String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(text, "Devops");
        Thread.sleep(3000);
    }
}
