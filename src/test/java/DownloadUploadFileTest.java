import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void testingDownload() throws InterruptedException {
      driver.get("https://leafground.com/file.xhtml");
      Thread.sleep(3000);

      WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
      downloadBtn.click();
      Thread.sleep(3000);

        File file = new File("C:\\Users\\Acer\\Downloads"); //using Java
        File[] totalFiles = file.listFiles(); //read all files in download path and strore in File[] array
        for (File findFiles:totalFiles){
            if (findFiles.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }

    @Test
    public void testingUpload() throws AWTException, InterruptedException {
        driver.get("https://leafground.com/file.xhtml");

//        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBtn.click();
//
//        //windows control begins here
//
//        String data = "C:\\Users\\Acer\\Downloads\\Migration.jpg";
//        StringSelection selection = new StringSelection(data); //StringSelection class = convert this data to a plain text
//
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);  //VK=Virtual Key
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(3000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


        //2nd way - using send keys (applicable only element type is file)

        String data = "C:\\Users\\Acer\\Downloads\\Migration.jpg";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
    }
}
