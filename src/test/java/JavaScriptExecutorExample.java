import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {


    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testingJavaScriptExecutor() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");


        jsExecutor = (JavascriptExecutor) driver;

//        //01) Set a alert box in to web page using JavaScript
//        jsExecutor.executeScript("alert('Welcome to learn automation!');");

        //02) Set an input value in a text box using javascriptExecutor

//            //2.1) Way 1 -> Set the value using the value property (Common approach)
//        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
//        jsExecutor.executeScript("arguments[0].value='Learn automation';", inputNameTextBox);

            //2.2) Way 2 -> Set the value using setAttribute (alternative approach)
        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].setAttribute('value', 'Learn automation');", inputNameTextBox);

        Thread.sleep(4000);

        //03) Highlight element
        jsExecutor.executeScript("arguments[0].style.border= 'red';", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background= 'yellow';", inputNameTextBox);

        Thread.sleep(4000);

        //04) Click element using javascriptExecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();", maleCheckBox);

        Thread.sleep(4000);

        //05) Scrolling the page
        scrollPage();

    }


    public void scrollPage(){
        //1) Scroll to some position
        jsExecutor.executeScript("window.scrollTo(0, 1000);");
        System.out.println("Current pageYOffset value is: "+jsExecutor.executeScript("return window.pageYOffset;"));

        jsExecutor.executeScript("window.scrollTo(0, -1000);");


        //2) Scroll to bottom of the page by pixel number
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //3) Scroll to te top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0);");

        //4) Scroll the page till element is visible
        WebElement scrollintoElement = driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollintoElement);
    }
}
