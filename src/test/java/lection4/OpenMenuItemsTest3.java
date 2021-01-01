package lection4;

import lection2.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OpenMenuItemsTest3 extends BaseTest {

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

        List<WebElement> menuItems = driver.findElements(By.xpath("//*[@class='name']"));
        String menuItemText;

        for (WebElement menuItem : menuItems) {
            menuItemText = menuItem.getText();

//            Все текстовые названия пунктов меню выводятся в консоль
            System.out.println(menuItemText);

// По такому локатору в браузере можно найти элемет - //span[contains(text(),'Appearence')]
// А так тест падает с StaleElementReferenceException, хотя должен быть такой же локатор
            driver.findElement(By.xpath("//span[contains(text(),'" + menuItemText + "')]")).click();

        }

    }

}