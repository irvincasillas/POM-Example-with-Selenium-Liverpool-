package tests;

import hook.Hook;
import org.junit.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultsPage;

public class SelectSmartTVByPriceBrandSizeTest extends Hook {

    String size = "43 pulgadas", brand = "SAMSUNG", textSearch = "Smart TV";
    int minPrice = 2000, maxPrice = 10000;

    @Test
    public void selectSmartTVByPriceBrandSize() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.performSearch(textSearch);
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.setPriceRange(2000,10000);
        Thread.sleep(2000);
        resultsPage.selectSizeFilter(size);
        Thread.sleep(2000);
        resultsPage.selectBrandFilter(brand);
        Thread.sleep(2000);
        resultsPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);

        boolean productInRange = productPage.validateProductPrizeBetweenRange(2000,10000);
        Assert.assertTrue(productInRange);

        boolean productTitle = productPage.validateProductTitleContainsBrand(brand);
        Assert.assertTrue(productTitle);

        boolean productSize = productPage.validateProductSize(size);
        Assert.assertTrue(productSize);
    }
}
