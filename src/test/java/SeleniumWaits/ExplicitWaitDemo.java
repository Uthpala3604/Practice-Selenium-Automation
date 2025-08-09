package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void testingExplicitWaits(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");

        WebElement newBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));

        String newBtnText = newBtnElement.getText();
        System.out.println("New button text is: "+newBtnText);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
