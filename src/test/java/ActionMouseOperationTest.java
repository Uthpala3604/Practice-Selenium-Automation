import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingMouseOperations() throws InterruptedException {
        driver.get("https://leafground.com/drag.xhtml");

        //01) Move to an element operation

//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).
                moveToElement(driver.findElement(By.id("menuform:j_idt38"))).
                moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();


        //02) Drag and Drop operation
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //ist way
//        actions.clickAndHold(from).moveToElement(to).release(to).perform();
        //2nd way
        actions.dragAndDrop(from,to).perform();

        //03) Slider

        WebElement sliderPoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span[1]"));
        System.out.println("Location of slider point 1 before moving: "+sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1, 50, 0).perform();
        System.out.println("Location of slider point 1 after moving: "+sliderPoint1.getLocation());

    }

    @Test
    public void testingMouseActions1() throws InterruptedException {
        //jQuery-context menu
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        //Right click
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClickBtn).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Alert text is: "+alertPop.getText());
        alertPop.accept();
    }

    @Test
    public void testingMouseActions2(){
        //DemoQA

        driver.get("https://demoqa.com/droppable");

        //draggable
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).perform();
    }
}
