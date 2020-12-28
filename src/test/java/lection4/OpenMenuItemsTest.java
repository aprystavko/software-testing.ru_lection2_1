package lection4;

import lection2.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class OpenMenuItemsTest extends BaseTest {

    // Before start test fill data into login and password fields
    String login = "";
    String password = "";

    // Urls:
    String adminUrl = "https://litecart.stqa.ru/admin/login.php";
    String baseUrl = "https://litecart.stqa.ru/admin/";
    String appearanceUrl = "?app=appearance&doc=template";
    String catalogUrl = "?app=catalog&doc=catalog";
    String countriesUrl = "?app=countries&doc=countries";
    String currenciesUrl = "?app=currencies&doc=currencies";
    String customersUrl = "?app=customers&doc=customers";
    String geoZoneUrl = "?app=geo_zones&doc=geo_zones";
    String languagesUrl = "?app=languages&doc=languages";
    String modulesUrl = "?app=modules&doc=jobs";
    String ordersUrl = "?app=orders&doc=orders";
    String pagesUrl = "?app=pages&doc=pages";
    String reportsUrl = "?app=reports&doc=monthly_sales";
    String settingsUrl = "?app=settings&doc=store_info";
    String slidesUrl = "?app=slides&doc=slides";
    String taxUrl = "?app=tax&doc=tax_classes";
    String translationsUrl = "?app=translations&doc=search";
    String usersUrl = "?app=users&doc=users";
    String vqmodsUrl = "?app=vqmods&doc=vqmods";

    private void authenticate() {
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@name=\"login\"]")).sendKeys(Keys.ENTER);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    private void openUrl(String url) {
        driver.navigate().to(url);
    }

    private void openUrlAndCheckHeader(String url) {
        driver.navigate().to(url);
        assertTrue(isElementPresent(By.xpath("//h1")));
    }

    private void openAppearenceMenuItem() {
        openUrlAndCheckHeader(baseUrl + appearanceUrl);
    }

    private void openCatalogMenuItem() {
        openUrlAndCheckHeader(baseUrl + catalogUrl);
    }

    private void openCountriesMenuItem() {
        openUrlAndCheckHeader(baseUrl + countriesUrl);
    }

    private void openCurrenciesMenuItem() {
        openUrlAndCheckHeader(baseUrl + currenciesUrl);
    }

    private void openCustomersMenuItem() {
        openUrlAndCheckHeader(baseUrl + customersUrl);
    }

    private void openGeoZoneMenuItem() {
        openUrlAndCheckHeader(baseUrl + geoZoneUrl);
    }

    private void openLanguagesMenuItem() {
        openUrlAndCheckHeader(baseUrl + languagesUrl);
    }

    private void openModulesMenuItem() {
        openUrlAndCheckHeader(baseUrl + modulesUrl);
    }

    private void openOrdersMenuItem() {
        openUrlAndCheckHeader(baseUrl + ordersUrl);
    }

    private void openPagesUrlMenuItem() {
        openUrlAndCheckHeader(baseUrl + pagesUrl);
    }

    private void openReportsMenuItem() {
        openUrlAndCheckHeader(baseUrl + reportsUrl);
    }

    private void openSettingsMenuItem() {
        openUrlAndCheckHeader(baseUrl + settingsUrl);
    }

    private void openSlidesMenuItem() {
        openUrlAndCheckHeader(baseUrl + slidesUrl);
    }

    private void openTaxMenuItem() {
        openUrlAndCheckHeader(baseUrl + taxUrl);
    }

    private void openTranslationsMenuItem() {
        openUrlAndCheckHeader(baseUrl + translationsUrl);
    }

    private void openUsersMenuItem() {
        openUrlAndCheckHeader(baseUrl + usersUrl);
    }

    private void openVqmodsUrlMenuItem() {
        openUrlAndCheckHeader(baseUrl + vqmodsUrl);
    }

    private void openSubMenuItem(String menuName) {
        driver.findElement(By.xpath("//span[contains(text(),'" + menuName + "')]")).click();
    }

    @Test
    public void LoginTest() {

        openUrl(adminUrl);
        authenticate();
        openAppearenceMenuItem();
        openSubMenuItem("Template");
        openSubMenuItem("Logotype");
        openCatalogMenuItem();
        openSubMenuItem("Catalog");
        openSubMenuItem("Product Groups");
        openSubMenuItem("Option Groups");
        openSubMenuItem("Manufacturers");
        openSubMenuItem("Suppliers");
        openSubMenuItem("Delivery Statuses");
        openSubMenuItem("Sold Out Statuses");
        openSubMenuItem("Quantity Units");
        openSubMenuItem("CSV Import/Export");
        openCountriesMenuItem();
        openCurrenciesMenuItem();
        openCustomersMenuItem();
        openSubMenuItem("Customers");
        openSubMenuItem("CSV Import/Export");
        openSubMenuItem("Newsletter");
        openGeoZoneMenuItem();
        openLanguagesMenuItem();
        openSubMenuItem("Languages");
        openSubMenuItem("Storage Encoding");
        openModulesMenuItem();
        openSubMenuItem("Background Jobs");
        driver.navigate().to("https://litecart.stqa.ru/admin/?app=modules&doc=customer");
        openSubMenuItem("Shipping");
        openSubMenuItem("Payment");
        openSubMenuItem("Order Total");
        openSubMenuItem("Order Success");
        openSubMenuItem("Order Action");
        openOrdersMenuItem();
        openSubMenuItem("Orders");
        openSubMenuItem("Order Statuses");
        openPagesUrlMenuItem();
        openReportsMenuItem();
        openSubMenuItem("Monthly Sales");
        openSubMenuItem("Most Sold Products");
        openSubMenuItem("Most Shopping Customers");
        openSettingsMenuItem();
        openSubMenuItem("Store Info");
        openSubMenuItem("Defaults");
        openSubMenuItem("General");
        openSubMenuItem("Listings");
        openSubMenuItem("Images");
        openSubMenuItem("Checkout");
        openSubMenuItem("Advanced");
        openSubMenuItem("Security");
        openSlidesMenuItem();
        openTaxMenuItem();
        openSubMenuItem("Tax Classes");
        openSubMenuItem("Tax Rates");
        openTranslationsMenuItem();
        openSubMenuItem("Search Translations");
        openSubMenuItem("Scan Files");
        openSubMenuItem("CSV Import/Export");
        openUsersMenuItem();
        openVqmodsUrlMenuItem();
        openSubMenuItem("vQmods");

    }

}