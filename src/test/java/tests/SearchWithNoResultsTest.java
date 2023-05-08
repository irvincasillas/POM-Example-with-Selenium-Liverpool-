package tests;

        import hook.Hook;
        import org.junit.Test;
        import org.testng.Assert;
        import pages.HomePage;
        import pages.ResultsPage;

public class SearchWithNoResultsTest extends Hook {

    String titleTextPage = "playstation900 | Liverpool.com.mx";
    String searchText = "playstation900";
    @Test
    public void searchTestWithNoResults() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        homePage.performSearch(searchText);
        Thread.sleep(5000);
        boolean findTitle = util.getTitle(titleTextPage);
        Assert.assertTrue(findTitle);

        String textLabel = resultsPage.verifyTextFromNullLabel();

        Assert.assertTrue(textLabel.contains(searchText));
    }

}

