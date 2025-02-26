package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static helper.Utility.driver;

public class WebPage {
    By button_login = By.id("login2");
    By input_username = By.id("loginusername");
    By input_pwd = By.id("loginpassword");
    By input_login = By.xpath("//button[normalize-space()='Log in']");
    By nameOfUser = By.id("nameofuser");



    public void openBrowser() {
        driver.get("https://www.demoblaze.com/");
    }

    public void buttonLogin() {
        driver.findElement(button_login).click();
    }

    public void inputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputpwd(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void inputLogin() {
        driver.findElement(input_login).click();
    }

    public void assertHomePage() {
        driver.findElement(nameOfUser).isDisplayed();
    }

    public void validateErrorMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();

        // Dapatkan teks dari alert
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Terima alert
        alert.accept();
    }

}
