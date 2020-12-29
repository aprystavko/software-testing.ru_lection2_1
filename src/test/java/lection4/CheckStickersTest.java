package lection4;

import lection2.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckStickersTest extends BaseTest {

    String baseUrl = "https://litecart.stqa.ru";

    private void openUrl(String url) {
        driver.navigate().to(url);
    }

    @Test
    public void CheckStickersNumber() {
        int counter = 1;
        openUrl(baseUrl);

        List<WebElement> mostPopularProducts = driver.findElements(By.xpath("//div[@id='box-most-popular']//ul//li"));
        List<WebElement> campaignsProducts = driver.findElements(By.xpath("//div[@id='box-campaigns']//ul//li"));
        List<WebElement> mostLatestProducts = driver.findElements(By.xpath("//div[@id='box-latest-products']//ul//li"));


        for (WebElement mostPopularProduct : mostPopularProducts) {
            List<WebElement> stickersInMostPopularProducts = mostPopularProduct.findElements(By.xpath("//div[@id='box-most-popular']//ul//li[" + counter + "]//*[contains(@class, 'sticker')]"));
            assertEquals("Each most popular products has exactly one sticker", 1, stickersInMostPopularProducts.size());
            counter++;
        }

        counter = 1;
        for (WebElement campaignsProduct : campaignsProducts) {
            List<WebElement> stickersInCampaignsProducts = campaignsProduct.findElements(By.xpath("//div[@id='box-campaigns']//ul//li[" + counter + "]//*[contains(@class, 'sticker')]"));
            counter++;
            assertEquals("Each campaigns products has exactly one sticker", 1, stickersInCampaignsProducts.size());
        }

        counter = 1;
        for (WebElement mostLatestProduct : mostLatestProducts) {
            List<WebElement> stickersInMostLatestProducts = mostLatestProduct.findElements(By.xpath("//div[@id='box-latest-products']//ul//li[" + counter + "]//*[contains(@class, 'sticker')]"));
            assertEquals("Each most latest products has exactly one sticker", 1, stickersInMostLatestProducts.size());
            counter++;
        }


    }

}