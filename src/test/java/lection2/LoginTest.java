package lection2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginTest extends BaseTest {

    // Before start test fill data into login and password fields
    String login = "";
    String password = "";

    @Test
    public void LoginTest() {
        driver.navigate().to("https://litecart.stqa.ru/admin/login.php");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name=\"login\"]")).sendKeys(Keys.ENTER);
    }

}