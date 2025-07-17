import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingFrames(){
        //leafground
        driver.get("https://leafground.com/frame.xhtml");

        //01) Click Me (Inside frame)

        driver.switchTo().frame(0);
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[@id='Click']"));
        clickMeBtn.click();
        String afterClickBtnText = clickMeBtn.getText();
        System.out.println("Text is: "+afterClickBtnText);

        //02) Click Me (Inside Nested frame)
        driver.switchTo().defaultContent(); //switch inside to main frame (main html page)
        driver.switchTo().frame(2); //inside into third frame
        driver.switchTo().frame("frame2"); //inside into third frame -> child frame

        WebElement clickMeBtn3 = driver.findElement(By.id("Click"));
        clickMeBtn3.click();
        String afterClickNestedBtnText = clickMeBtn3.getText();
        System.out.println("Text of nested frame btn: "+ afterClickNestedBtnText);

        //03) Num of frames in the page
        driver.switchTo().defaultContent();

        List<WebElement> getIframeTageCount =  driver.findElements(By.tagName("iframe"));
        int size = getIframeTageCount.size();
        System.out.println("IFrame tage count: "+size);

        for (WebElement iframeElement: getIframeTageCount){
            String frameSRCattributeValue = iframeElement.getAttribute("src");
            System.out.println("frame src attribute value: "+frameSRCattributeValue);
        }
    }

    @Test
    public void testingFrames2(){
        //DemoQA
        driver.get("https://demoqa.com/frames");

        //01) First frame
        driver.switchTo().frame("frame1");

        WebElement firstFrame = driver.findElement(By.id("sampleHeading"));
        String insideText = firstFrame.getText();
        System.out.println("First frame text is: "+insideText);

        //02) Second frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement secondFrame = driver.findElement(By.id("sampleHeading"));
        String secondInsideText = secondFrame.getText();
        System.out.println("Second frame text is: "+secondInsideText);

        //03) Frame count
        driver.switchTo().defaultContent();
        List<WebElement> frameCount = driver.findElements(By.tagName("iframe"));
        System.out.println("Frame count is: "+frameCount.size());
    }

}
