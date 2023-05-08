package tests;

import hook.Hook;
import org.junit.Test;
import org.testng.Assert;
import pages.HomePage;

public class SearchTest extends Hook {

    String titleTextPage = "playstation | Liverpool.com.mx";
    @Test
    public void searchTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.performSearch("playstation");
        Thread.sleep(5000);
        boolean findTitle = util.getTitle(titleTextPage);

        Assert.assertTrue(findTitle);
    }

}
