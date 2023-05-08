package tests;

import hook.Hook;
import org.junit.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultsPage;

public class SearchUsingBrandSuggestionTest extends Hook {

    String titleTextPage = "playstation | Liverpool.com.mx";

    @Test
    public void searchByBrandFromSuggestions() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        homePage.setTextToSearch("tenis");
        Thread.sleep(2500);
        homePage.performSearchUsingSuggestion("brand");
        boolean wasFound = resultsPage.searchStringInBreadcrumb("ADIDAS");
        Assert.assertTrue(wasFound);


    }

}
