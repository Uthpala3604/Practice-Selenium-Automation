import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        Dimension newSize = new Dimension(400, 600);
        driver.manage().window().setSize(newSize);
    }

    @Test
    public void testingButton(){

        //leafground
        driver.get("https://leafground.com/button.xhtml");

        //01) Click and Confirm title.
        WebElement clickButton = driver.findElement(By.id("j_idt88:j_idt90"));
        clickButton.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
//        if (expectedTitle.equals(actualTitle)){
//            System.out.println("Actual title is same as expected");
//        }else {
//            System.out.println("Actual title is not same as expected");
//        }

       Assert.assertEquals(actualTitle, expectedTitle, "Actual title is not same as expected");

        driver.navigate().back();

        //02) Find the button position
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is: " + x + "Y position is: " + y);

        //03) Find the save button color
        WebElement buttonColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println(color);

        //04) Find the height and width of the button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        Dimension diamension = size.getSize();
        int height = diamension.getHeight();
        int width = diamension.getWidth();
        System.out.println("Height is : "+ height+ " Width is: "+width);

        //05) Check the button is disabled
        WebElement disabled = driver.findElement(By.id("j_idt88:j_idt92"));
        boolean enabled = disabled.isEnabled();
        System.out.println("Is the button enabled: "+enabled);

    }

}
