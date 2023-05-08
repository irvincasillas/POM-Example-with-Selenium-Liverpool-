package tests;

import hook.Hook;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ResultsPage;

public class BuyProductTest extends Hook {


    String textSearch = "playstation 5";
    String email = "110irving@gmail.com";
    String password = "Asd12345";
    String productTitle;

    @Test
    public void BuyProductTestFromZero() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.performSearch(textSearch);
        Thread.sleep(2000);

        resultsPage.clickFirstProduct();
        productTitle = productPage.getProductTitle();
        productPage.clickOnBuyButton();

        Thread.sleep(2000);
        loginPage.performLogin(email,password);
        //requires verification code from cellphone after this step

        Thread.sleep(15000);





    }





}
