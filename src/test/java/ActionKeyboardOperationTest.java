import org.checkerframework.checker.units.qual.C;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;

public class ActionKeyboardOperationTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingKeyboardActions1() throws InterruptedException {
        //google
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("Welcome");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(3000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence").perform();

        Thread.sleep(5000);
        actions.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .build().perform();

//        //To write in a capital in a text box
//        actions.keyDown(googleSearchTextBox, Keys.SHIFT)
//                .sendKeys("learn automation")
//                .perform();

    }

    @Test
    public void testingKeyboardActions2() throws InterruptedException {
        //leafground
        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable  = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is: "+size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(3))
                .perform();

    }



}
