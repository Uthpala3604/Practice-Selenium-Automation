import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingAlert() throws InterruptedException {
        //leafground
        driver.get("https://leafground.com/alert.xhtml");

        //01) Simple alert
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //02) Alert (Confirm Dialog)
        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        //03) Alert (Prompt Dialog)
        WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promptBox.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert Text is: "+alertText);
        alert2.sendKeys("My name is Uthpala");
        alert2.accept();

        //04) Sweet Alert (Simple Dialog)
        WebElement simpleAlertBox = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']"));
        simpleAlertBox.click();
        WebElement dialogBox = driver.findElement(By.id("j_idt88:j_idt96"));
        String dialogBoxText = dialogBox.getText();
        System.out.println("Dialog box text is : "+dialogBoxText);
        WebElement dismissBtn = driver.findElement(By.id("j_idt88:j_idt98"));
        dismissBtn.click();

        //05) Sweet Modal Dialog
        WebElement sweetModelBox = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"));
        sweetModelBox.click();
        WebElement dialogBox1 = driver.findElement(By.id("j_idt88:j_idt101"));
        String dialogBoxText1 = dialogBox1.getText();
        System.out.println("Sweet model dialog is: "+dialogBoxText1);
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt101']/div[1]/a"));
        closeBtn.click();

        //06) Sweet Alert (Confirmation)
        WebElement deleteBtn = driver.findElement(By.id("j_idt88:j_idt106"));
        deleteBtn.click();
        WebElement confirmDialogBox = driver.findElement(By.id("j_idt88:j_idt107"));
        String confirmMessage = confirmDialogBox.getText();
        System.out.println("Confirmation text: "+confirmMessage);
        WebElement yesBtn = driver.findElement(By.id("j_idt88:j_idt108"));
        yesBtn.click();

        //07) Minimize and Maximize
        WebElement showBtn = driver.findElement(By.id("j_idt88:j_idt111"));
        showBtn.click();
        Thread.sleep(3000);
        WebElement minMaxBox = driver.findElement(By.id("j_idt88:j_idt112"));
        String minMaxText = minMaxBox.getText();
        System.out.println("Min and Max text is: "+minMaxText);
        Thread.sleep(3000);
        WebElement maxBtn = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt112']/div[1]/a[2]"));
        maxBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn1 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt112']/div[1]/a[1]"));
        closeBtn1.click();

    }

    @Test
    public void testingAlert1() throws InterruptedException {
        //DemoQA
        driver.get("https://demoqa.com/alerts");

        //01) Click Button to see alert
        WebElement clickBtn = driver.findElement(By.id("alertButton"));
        clickBtn.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text is: "+ alertText);
        Thread.sleep(3000);
        alert.accept();

        //02) On button click, alert will appear after 5 seconds
        WebElement timeAlertBtn = driver.findElement(By.id("timerAlertButton"));
        timeAlertBtn.click();
        Thread.sleep(6000);
        Alert alert1 = driver.switchTo().alert();
        String alertText1 = alert1.getText();
        System.out.println("Alert text of timer alert is: "+alertText1);
        alert1.accept();

        //03) On button click, confirm box will appear
        driver.findElement(By.id("confirmButton")).click();
        Alert alert2 = driver.switchTo().alert();
        String confirmText = alert2.getText();
        System.out.println("Confirm alert text is: "+confirmText);
        Thread.sleep(3000);
        alert2.dismiss();

        //04) On button click, prompt box will appear
        WebElement promptBtn = driver.findElement(By.id("promtButton"));
        promptBtn.click();
        Thread.sleep(3000);
        Alert alert3 = driver.switchTo().alert();
        System.out.println("Prompt text is: "+alert3.getText());
        alert3.sendKeys("Uthpala");
        Thread.sleep(3000);
        alert3.accept();


    }



}
