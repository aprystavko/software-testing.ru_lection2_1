package lection3;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginInDifferentBrowsers {
    public WebDriver webDriver;
    public WebDriverWait wait;

    // Before start test fill data into login and password fields
    String login = "";
    String password = "";

    @Test
    public void loginInChrome() {
        File chromeDriver = new File("src/main/resources/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        setUpBrowser();
        executeLogin();
    }

     @Test
     public void loginInMozilla() {
         File geckoDriver = new File("src/main/resources/drivers/geckodriver");
         System.setProperty("webdriver.gecko.driver", geckoDriver.getAbsolutePath());
         webDriver = new FirefoxDriver();
         setUpBrowser();
         executeLogin();
     }

    @Test
    public void loginInSafari() {
        webDriver = new SafariDriver();
        setUpBrowser();
        executeLogin();
    }

     public void setUpBrowser(){
         wait = new WebDriverWait(webDriver, 10);
         webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         webDriver.manage().window().maximize();
         String winHandleBefore = webDriver.getWindowHandle();
         webDriver.switchTo().window(winHandleBefore);
     }

    public void executeLogin(){
        webDriver.navigate().to("https://litecart.stqa.ru/admin/login.php");
        webDriver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(login);
        webDriver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[@name=\"login\"]")).sendKeys(Keys.ENTER);
    }


    @After
    public void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

}