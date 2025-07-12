import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioBtnCheckBoxTest {
    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingRadioButton(){
        driver.get("https://leafground.com/radio.xhtml");

        //01) find the default select radio button

        boolean chromeRadioBtn = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean fireFoxRadioBtn = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioBtn = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioBtn = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadioBtn){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is: "+chromeText);
        }else if (fireFoxRadioBtn){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is: "+firefoxText);
        }else if (safariRadioBtn){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is: "+safariText);
        }else if (edgeRadioBtn){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is: "+edgeText);
        }


        //02 select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if (!isChecked){
            //myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }

        //03) Select favourite option
        driver.findElement(By.xpath("//label[@for='j_idt87:console1:3']")).click();


    }

    @Test
    public void testingCheckBox(){
        driver.get("https://leafground.com/checkbox.xhtml");

        //01) select wanted checkboxes and verifying those checkboxes selected status

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkBoxList){
            if (!(element.getText().equals("Others"))){ //select all checkboxes except "Others"
                element.click();
            }
        }

        for (int i=1; i<=checkBoxList.size(); i++){
           boolean checkBoxStatus =  driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("Checkbox "+i+ "selected status is: "+checkBoxStatus);
        }

        //02) Basic checkbox
        driver.findElement(By.id("j_idt87:j_idt89")).click();


        //03) Notification
        WebElement notification = driver.findElement(By.id("j_idt87:j_idt91"));
        notification.click();
        String notifyText = notification.getText();
        System.out.println(notifyText);

        //04) Verify if check box is disabled
        WebElement disabled =driver.findElement(By.id("j_idt87:j_idt102_input"));
        boolean enabled = disabled.isEnabled();
        System.out.println("Is the checkbox enabled? : "+enabled);

    }

    @Test
    public void demoQARadioBtnTest(){
        driver.get("https://demoqa.com/radio-button");

        //01) select option
        driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();

        //02) Check disable btn
        WebElement disabled = driver.findElement(By.id("noRadio"));
        boolean enable = disabled.isEnabled();
        System.out.println("Is the checkbox enabled? : "+enable);
    }

}
