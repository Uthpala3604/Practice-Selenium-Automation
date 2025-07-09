import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTest {

    WebDriver driver;

    @BeforeMethod
    public void openPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://leafground.com/link.xhtml");
        driver.get("https://demoqa.com/links");
    }

    @Test
    public void LinksTest(){

//        //01) Take me to dashboard
//        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
//        homeLink.click(); //click and go to dashboard
//        driver.navigate().back(); //back to page
//
//        //02) Find my destination
//        WebElement wheretoGo  = driver.findElement(By.partialLinkText("Find the URL"));
//        String path = wheretoGo.getAttribute("href");
//        System.out.println("This link is going to: "+path);
//
//        //03) Am I broken link?
//        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
//        brokenLink.click();
//        String title = driver.getTitle();
//        if (title.contains("404")){
//            System.out.println("The link is broken");
//        }else {
//            System.out.println("Not broken");
//        }
//        driver.navigate().back();
//
//        //04) Duplicate Link
//        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
//        homeLink1.click();
//        driver.navigate().back();
//
//        //05) Count Links
//        List<WebElement> linkCount = driver.findElements(By.tagName("a"));
//        int pageLinkCount = linkCount.size();
//        System.out.println("Counts of full page links: "+ pageLinkCount);
//
//        //06) Count Layout Links
//        WebElement sectionLinks = driver.findElement(By.className("layout-main-content"));
//        List<WebElement> countOfLayoutLinks = sectionLinks.findElements(By.tagName("a"));
//        int layoutLinkCount = countOfLayoutLinks.size();
//        System.out.println("Count of links in the section: "+layoutLinkCount);


        //01) Go to home page
        WebElement goToHome = driver.findElement(By.linkText("Home"));
        goToHome.click();
        //driver.navigate().back();

        //02) Created
        WebElement createLink = driver.findElement(By.linkText("Created"));
        createLink.click();
        createLink.getAttribute("Created");
        System.out.println("201 Created");

        //03) No Content
        WebElement noContentLink =driver.findElement(By.linkText("No Content"));
        noContentLink.click();
        noContentLink.getAttribute("204");
        System.out.println("204 No Content");

        //04) Moved
        WebElement movedLink = driver.findElement(By.linkText("Moved"));
        movedLink.click();
        movedLink.getAttribute("Moved Permanently");
        System.out.println("301 Moved Permanently");

        //05) Bad Request
        WebElement badRequestLink = driver.findElement(By.id("bad-request"));
        badRequestLink.click();
        badRequestLink.getAttribute("400");
        System.out.println("400 Bad Request");

        //06) Count links in the page
        List<WebElement> linkCountPage = driver.findElements(By.id("a"));
        int countOfLinks = linkCountPage.size();
        System.out.println("Full count of links in the page: " + countOfLinks);

        //07) Link count in the section
        WebElement sectionFind = driver.findElement(By.id("linkWrapper"));
        List<WebElement> sectionLinkCount = sectionFind.findElements(By.id("a"));
        System.out.println("Full count 0f links in the section: "+sectionLinkCount.size());


    }


}
