package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By inputSearch = By.id("mainSearchbar");
    By searchButton = By.xpath("//button[@class='input-group-text']");
    By firstBrandElement = By.xpath("//div[@class='col-lg-4 col-12 results']//a[6]");
    By firstCategoryElement = By.xpath("//div[@class='col-lg-4 col-12 results']//a[11]");
    By loginButton = By.xpath("//span[@class='a-header__topLink']");

    public HomePage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void setTextToSearch(String text){
        driver.findElement(inputSearch).sendKeys(text);

    }

    public void performSearch(String text){
        driver.findElement(inputSearch).sendKeys(text);
        driver.findElement(searchButton).click();

    }

    public void performSearchUsingSuggestion(String text){
        this.setTextToSearch(text);
        if(text.equals("brand")){
            driver.findElement(firstBrandElement).click();
        }else{
            driver.findElement(firstCategoryElement).click();
        }
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


}
