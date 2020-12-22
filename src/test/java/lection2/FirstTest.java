package lection2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends BaseTest {

    @Test
    public void myFirstTest() {
        webDriver.navigate().to("https://www.google.com");
        webDriver.findElement(By.name("q")).sendKeys("Hello google");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleIs("Hello google - Пошук Google"));
    }

}