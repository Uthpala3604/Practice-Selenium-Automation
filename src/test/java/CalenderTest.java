import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void testingCalender(){
        driver.get("https://jqueryui.com/datepicker/");

        //Method 1

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//
//        datePicker.sendKeys("07/30/2025");

        //method 2
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

//        while (true){
//            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
//            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
//
//            if(actualYear.equals("2026") && actualMonth.equals("May")){
//                break;
//            }else {
//                driver.findElement(By.xpath("//a[@title='Next']")).click();
//            }
//        }
//
//        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
//
//        for (WebElement dataElement:allDates){
//            if (dataElement.getText().equals("3")){
//                dataElement.click();
//                break;
//            }
//        }

        //selectFutureDate("2026", "May", "6");
        selectPastDate("2024", "May", "24");
    }

    public void selectFutureDate(String year, String month, String day){
        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if(actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dataElement:allDates){
            if (dataElement.getText().equals(day)){
                dataElement.click();
                break;
            }
        }
    }

    public void selectPastDate(String year, String month, String day){
        while (true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if(actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dataElement:allDates){
            if (dataElement.getText().equals(day)){
                dataElement.click();
                break;
            }
        }

    }
}
