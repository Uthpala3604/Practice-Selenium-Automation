import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingDropDown() throws InterruptedException {
        //leadfground
        driver.get("https://leafground.com/select.xhtml");

        //01) Ways of select values in basic dropdown
        WebElement dropDown =driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //02) Get the number of dropdown options
        List<WebElement> listOfOptions = select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of elements in dropdown: "+size);

        for(WebElement element:listOfOptions){
            System.out.println(element.getText());
        }

        //03) Using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //04) Selecting value in a Boostrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listOfDropdownValues = dropDown2.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element:listOfDropdownValues){
            String dropDownValue = element.getText();
            if (dropDownValue.equals("USA")){
                element.click();
                break;
            }

        }
    }

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");

        //01) Google search - pick a value from suggestions
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        for (WebElement element:googleSearchList){
            System.out.println(element.getText());

        }
    }

    @Test
    public void testingDropDown2(){
        //the internet herokuapp
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDownH = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select2 = new Select(dropDownH);
        select2.selectByValue("2");
    }

}
