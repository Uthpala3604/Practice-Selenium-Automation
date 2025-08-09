package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitsDemo {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void testingFluentWaits(){

        //Declaration (define fluent wait)
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                .withTimeout(Duration.ofSeconds(30))  //Maximum time to wait
                                .pollingEvery(Duration.ofSeconds(5))   //Frequency to check the condition
                                .ignoring(NoSuchElementException.class);  //Ignore specific exceptions


        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New button text is: "+newBtnText);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
