package lection2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    String browser = System.getProperty("browser");


    @Before
    public void setUp() {
        setBrowser();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
    }

    private void setBrowser() {
        if (browser == null) {
            browser = "chrome";
        }

        if ("chrome".equals(browser)) {
            File chromeDriver = new File("src/main/resources/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            driver = new ChromeDriver();
        } else {
            Assert.fail("Can't open browser" + browser);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}