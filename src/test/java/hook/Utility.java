package hook;

import org.openqa.selenium.WebDriver;

public class Utility {
    WebDriver driver;

    public Utility(WebDriver driver){
        this.driver = driver;
    }

    public boolean getTitle(String titleText){
        String title = driver.getTitle();
        System.out.println("pagetitle :"+title);
        boolean findText = title.contains(titleText);
        return findText;
    }

    public boolean getUrl(String urlLoginExpected){
        String Url = driver.getCurrentUrl();
        boolean findUrl = Url.contains(urlLoginExpected);
        return findUrl;
    }

}
