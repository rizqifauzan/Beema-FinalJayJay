package stepDef;

import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ProductPage;
import pages.WebPage;


public class WebStep {

    WebPage webPage;
    ProductPage productPage;


    public WebStep(){
        this.webPage = new WebPage();
        productPage = new ProductPage(Utility.driver);
    }

    @Given(": open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        webPage.buttonLogin();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String pwd) {
        webPage.inputpwd(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.inputLogin();
    }

    @And("user will see icon name of user")
    public void userWillSeeIconNameOfUser() {
        webPage.assertHomePage();
    }

    @And("user on the page and will see error message {string}")
    public void userOnThePageAndWillSeeErrorMessage(String message) throws InterruptedException {
        webPage.validateErrorMessage(message);
    }

    @And("user click next page")
    public void userClickNextPage()throws InterruptedException {
        productPage.buttonNextPage();
    }

    @And("user will see button previous page")
    public void userWillSeeButtonPreviousPage() {
        productPage.assertPage2();
    }

    @And("user click previous page")
    public void userClickPreviousPage()throws InterruptedException {
        productPage.buttonPreviousPage();
    }

    @And("click  button add to cart")
    public void clickButtonAddToCart() {
        productPage.addToCart();}

    @And("user click phones button")
    public void userClickPhonesButton()throws InterruptedException {
        productPage.assertPhonesButton();
    }

    @And("click detail item {string}")
    public void clickDetailItem(String item) throws InterruptedException {
        Thread.sleep(1000);
        productPage.clickItem(item);
    }
}
