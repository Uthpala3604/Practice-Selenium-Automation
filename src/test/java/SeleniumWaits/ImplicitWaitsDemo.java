package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitsDemo {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));  //within 1sec, load the page, otherwise throw an exception
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void testingImplicitWaits() throws InterruptedException {

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        //Thread.sleep(10000);

        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New button text is: "+newBtnText);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
