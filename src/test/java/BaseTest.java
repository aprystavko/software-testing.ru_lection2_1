import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;
    public WebDriverWait wait;
    String browser = System.getProperty("browser");


    @Before
    public void setUp() {
        setBrowser();
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        String winHandleBefore = webDriver.getWindowHandle();
        webDriver.switchTo().window(winHandleBefore);
    }

    private void setBrowser() {
        if (browser == null) {
            browser = "chrome";
        }

        if ("chrome".equals(browser)) {
            File chromeDriver = new File("src/main/resources/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else {
            Assert.fail("Can't open browser" + browser);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

}