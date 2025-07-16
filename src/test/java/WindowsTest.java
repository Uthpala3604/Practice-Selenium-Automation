import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testingWindows() throws InterruptedException {
        //leafground
        driver.get("https://leafground.com/window.xhtml");
        Thread.sleep(3000);

        //01)Click and Confirm new Window Opens
//
        String oldWindow  =driver.getWindowHandle();
        System.out.println("Parent window: "+oldWindow);


        WebElement openBtn = driver.findElement(By.id("j_idt88:new"));
        openBtn.click();
        Thread.sleep(3000);


        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles size: "+handles.size()); // handles.size() = parent window+child window = 2


        //First method - using for-each loop
        for(String newWindow :handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("page title is: "+ driver.getTitle());
        }

        driver.close();

        driver.switchTo().window(oldWindow); //again switch to parent window

        WebElement openBtn1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean openBtnVisibility = openBtn1.isDisplayed();
        System.out.println("Open button visibility: "+openBtnVisibility);

//        //Second method - using List
//
//        List<String> list = new ArrayList<>(handles); //converting Set to list
//        if (list.size() > 1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("child tab title is: "+ driver.getTitle());
//            driver.close();
//            driver.switchTo().window(oldWindow);
//        }
//
//        WebElement openBtn1 = driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
//        boolean openBtnVisibility = openBtn1.isDisplayed();
//        System.out.println("Open button visibility: "+openBtnVisibility);

        //02) Find the number of opened tabs
        WebElement multiWindowBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiWindowBtn.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int numOfWindows = multiWindows.size();
        System.out.println("Number of windows opened: "+numOfWindows);

        //03) Close all windows except Primary
        WebElement dontCloseMeBtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        dontCloseMeBtn.click();
        Thread.sleep(3000);

        Set<String> newWindowHandles = driver.getWindowHandles();
        for (String allWindows:newWindowHandles){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }

        driver.switchTo().window(oldWindow);
        driver.close();

    }

    @Test
    public void testingWindows2() throws InterruptedException {
        //DemoQA
        driver.get("https://demoqa.com/browser-windows");


        //01) Open new tab

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window: "+oldWindow);

        WebElement newTabBtn = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newTabBtn.click();
        Thread.sleep(3000);

        Set<String> handles =driver.getWindowHandles();
        System.out.println("Multiple windows and tabs count: "+handles.size());

        for (String newWindow:handles) {
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is: " + driver.getTitle());
        }
        driver.close();
        driver.switchTo().window(oldWindow);

        WebElement newTabBtn1 = driver.findElement(By.xpath("//button[@id='tabButton']"));
        boolean newTabBtnVisibility = newTabBtn.isDisplayed();
        System.out.println("New tab button visibility: "+newTabBtnVisibility);


        //02) Open new window

        String  oldWindow1 = driver.getWindowHandle();
        System.out.println("Parent window is: "+oldWindow1);

        WebElement newWindowBtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
        newWindowBtn.click();
        Thread.sleep(3000);

        Set<String> handles1 = driver.getWindowHandles();
        System.out.println("Multiple windows: "+handles1.size());

        for (String newWindows1:handles1){
            System.out.println(newWindows1);
            driver.switchTo().window(newWindows1);
            System.out.println("Window title is: "+driver.getTitle());
        }

        driver.close();
        driver.switchTo().window(oldWindow1);

        WebElement newWindowBtn1 = driver.findElement(By.xpath("//button[@id='windowButton']"));
        boolean newWindowBtnVisibility = newWindowBtn1.isDisplayed();
        System.out.println("New window button visibility: "+ newWindowBtnVisibility);


        //03) New window message

        String oldWindow3 = driver.getWindowHandle();
        System.out.println("Old window is: "+oldWindow3);

        WebElement messageBtn = driver.findElement(By.id("messageWindowButton"));
        messageBtn.click();
        Thread.sleep(3000);

        Set<String> handles2 = driver.getWindowHandles();
        System.out.println("Multiple open windows: "+handles2.size());

        for (String windowOpen:handles2){
            System.out.println(windowOpen);
            driver.switchTo().window(windowOpen);
//            System.out.println("The message: "+driver.getTitle());
        }

        driver.close();
        driver.switchTo().window(oldWindow3);

        WebElement messageBtn1 = driver.findElement(By.id("messageWindowButton"));
        boolean messageBtnVisibility = newTabBtn.isDisplayed();
        System.out.println("Message button visibility: "+messageBtnVisibility);



    }
}
