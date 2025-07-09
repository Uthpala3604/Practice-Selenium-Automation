import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testingTextBox(){
        //Leafground
        driver.get("https://leafground.com/input.xhtml");

        //01) Type your name
        WebElement typeName = driver.findElement(By.id("j_idt88:name"));
        typeName.sendKeys("Uthpala Pathirana");
        //driver.findElement(By.id("j_idt88:name")).sendKeys("Uthpala Pathirana");

        //02) Append Country to this City.
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");
        //driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");

        //03) Verify if text box is disabled
        WebElement checkDisable = driver.findElement(By.name("j_idt88:j_idt93"));
        boolean enabled = checkDisable.isEnabled();
        //boolean enabled = driver.findElement(By.name("j_idt88:j_idt93"));
        System.out.println("Is text box enabled: "+ enabled);

        //04) Clear the typed text.
        WebElement clearText = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05) Retrieve the typed text.
        WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String  textValue = retrieveText.getAttribute("value");
        System.out.println(textValue);


        //06) Type email and Tab. Confirm control moved to next element.
        WebElement emailText = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']"));
        emailText.sendKeys("abc@mail.com" + Keys.TAB + "Confirmed control moved to next element");

    }

    @Test
    public void textingTextBoxTest(){
        //DemoQA
        driver.get("https://demoqa.com/text-box");

        //01) Type full name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Uthpala Pathirana");

        //02) email
        driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");

        //03) Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Araliya Road, Kandy.");

        //04) Permanent address
        driver.findElement(By.id("permanentAddress")).sendKeys("Araliya Road, Kandy.");

    }
}
