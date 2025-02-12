package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static helper.Utility.driver;

public class ProductPage {
    String itemName = ("//a[@href='prod.html?idp_=1']");
    By nextPage = By.xpath("//button[@id='next2']");
    By previousPage = By.id("prev2");
    By detailProductNexus = By.xpath("//body/div[@id='contcont']/div[@class='row']/div[@class='col-lg-9']/div[@id='tbodyid']/div[1]");
    By addToCart = By.xpath("//a[@onclick=\"addToCart(1)\"]");
    By macbookProIcon = By.xpath("//body/div[@id='contcont']/div[@class='row']/div[@class='col-lg-9']/div[@id='tbodyid']/div[1]");
    By phonesButton = By.xpath("//a[@onclick=\"byCat('phone')\"]");

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String generateLocator(String itemName){
        String locator = "//a[.='"+ itemName + "']";
        return locator;
    }

    public void clickItem(){
        driver.findElement(By.xpath(generateLocator(itemName))).click();
    }

    public void buttonNextPage() {
        driver.findElement(nextPage).click();
    }

    public void assertPage2() {
        driver.findElement(macbookProIcon).isDisplayed();
    }

    public void buttonPreviousPage() {
        driver.findElement(previousPage).click();
    }

    public void buttonDetailProductNexus() {
        driver.findElement(detailProductNexus).click();
    }
    public void addToCart() {
        driver.findElement(addToCart).click();
    }

    public void assertPhonesButton() {
        driver.findElement(phonesButton).click();
    }
}
