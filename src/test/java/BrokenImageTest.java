import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImageTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingBrokenImage(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images =  driver.findElements(By.xpath("//div[@class='example']/img"));

        //natural width = 0 --> image is broken

        int i = 1;
        for (WebElement image:images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image "+i+" is broken ");
            }else {
                System.out.println("Image " +i+ " is not broken");
            }
            i++;

        }
    }

    @Test
    public void testingBrokenImage2(){
        driver.get("https://demoqa.com/broken");

        WebElement image = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/img[1]"));

        if (image.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is broken");
        }else {
            System.out.println("Image is not broken");
        }
    }

}
