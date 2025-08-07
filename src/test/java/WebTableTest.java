import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingWebTable() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");

        //01) How many rows in the table
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row count is: "+rowCount);


        //02) How many columns in the table
        int coulnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Coulmn count is: "+coulnCount);


        //03) Retrieve the specific row/column data
        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("The value is: "+value);

        //04) Retrieve all the data from the table

        for (int i=1; i<=rowCount; i++){   //rows
            for (int j=1; j<coulnCount; j++){  //columns
                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData+ " ");
            }
            System.out.println();
        }


        //05) Print ID and name only
//
//        for (int i=1; i<=rowCount; i++){
//            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
//            String tableProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
//
//            System.out.println("Table ID : "+tableID + " Product name is : "+tableProductName);
//        }

        //5.1) Find the product price, which name related to product 3
        for (int i=1; i<=rowCount; i++){
            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String tableProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();

            System.out.println("Table ID : "+tableID + " Product name is : "+tableProductName);

            if(tableProductName.equals("Product 3")){
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println(tableProductName + "Relevent product price is: "+productPrice);
                break;
            }
        }


        //06) Select all the checkBoxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int i=0; i<pageCount; i++){
            pages.get(i).click();
            Thread.sleep(1000);
            for (int j=1; j<=rowCount; j++){
                boolean atb = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input")).isSelected();
                if (!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }


            //06) Select one checkbox
            int tableRow = 1;
            driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tableRow+"]/td[4]/input")).click();
        }


    }
}
