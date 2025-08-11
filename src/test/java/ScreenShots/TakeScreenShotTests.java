package ScreenShots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenShotTests {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void testingTakeScreenShots() throws IOException, AWTException {
        //01) Capture Screenshot of full page

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;  //because we take ss in webpage(driver)
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); //take the ss and store somewhere

        //E:\Automate Website\ScreenShots
        //File destinationFile = new File("E:\\Automate Website\\ScreenShots");
        File destinationFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ "alert_full_web_page.png");
        FileHandler.copy(sourceFile,destinationFile);


        //02) Capture Screenshot of a section of the web page

        WebElement section1PageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1PageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ "alert_section_of_the_page.png");
        FileHandler.copy(source,target);

        //03) Capture ScreenShot of an element of the web page



        WebElement elementOfPage = driver.findElement(By.xpath("//body/div[@class='layout-wrapper layout-wrapper-slim-sidebar slim']/div[@class='layout-main']/div[@class='layout-main-content']/form[@id='j_idt88']/div[@class='grid overlay-demo']/div[1]/div[1]"));
        File source1 = elementOfPage.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ "alert_element_of_the_page.png");
        FileHandler.copy(source1, target1);


//        //04) Click the alert button and get the full page ss  -- this way, it gives an exception
//
//        WebElement alertBox = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
//        alertBox.click();
//
//        TakesScreenshot takesScreenshot2 = (TakesScreenshot) driver;  //because we take ss in webpage(driver)
//        File sourceFile2 = takesScreenshot2.getScreenshotAs(OutputType.FILE); //take the ss and store somewhere;
//        File destinationFile2 = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ "alert_full_web_page2.png");
//        FileHandler.copy(sourceFile2,destinationFile2);


        //04) Capture ss of full entire page (with task bar and everything)

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source3 = robot.createScreenCapture(rectangle);
        File destinationFile3 = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ "alert_page_entireScreen.png");
        ImageIO.write(source3, "png", destinationFile3);

    }
}
