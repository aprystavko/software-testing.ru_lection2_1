package lection4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lection2.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OpenMenuItemsTest2 extends BaseTest {

    // Before start test fill data into login and password fields
    String login = "";
    String password = "";

    // Urls:
    String adminUrl = "https://litecart.stqa.ru/admin/login.php";
    String baseUrl = "https://litecart.stqa.ru/admin/";


    private void authenticate() {
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name=\"login\"]")).sendKeys(Keys.ENTER);
    }

    private void openUrl(String url) {
        driver.navigate().to(url);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Test
    public void MenuTest() {
        openUrl(adminUrl);
        authenticate();

        List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li/a"));

        // Так работает
//        String currentUrl = String.valueOf(menuItems.get(1).getAttribute("href"));
//        System.out.println(currentUrl);
//        driver.navigate().to(currentUrl);
        //


        // А так падает с ошибкой StaleElementReferenceException
        for (WebElement menuItem : menuItems) {
            String currentUrl = String.valueOf(menuItem.getAttribute("href"));
            driver.navigate().to(currentUrl);
        }
        //

    }

}