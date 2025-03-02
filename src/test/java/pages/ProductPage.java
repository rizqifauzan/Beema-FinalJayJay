package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    By nextPage = By.id("next2");
    By previousPage = By.id("prev2");
    By addToCart = By.xpath("//a[@onclick=\"addToCart(1)\"]");
    By phonesButton = By.xpath("//a[@onclick=\"byCat('phone')\"]");

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String generateLocator(String itemName){
        String locator = "//a[.='"+ itemName + "']/parent::h4/parent::div/parent::div/a";
        return locator;
    }

    public void clickItem(String item)throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath(generateLocator(item))).click();
    }

    public void buttonNextPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(nextPage).click();
    }

    public void assertPage2() {
        driver.findElement(previousPage).isDisplayed();
    }

    public void buttonPreviousPage() throws InterruptedException {
            Thread.sleep(2000);
        driver.findElement(previousPage).click();
    }
//
//    public void buttonDetailProductNexus() {
//        driver.findElement(detailProductNexus).click();
//    }

    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void assertPhonesButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(phonesButton).click();
    }
}