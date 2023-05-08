package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage {
    WebDriver driver;

    By nullProductLabel = By.xpath("//p[@class='o-nullproduct-title-query']//b[1]");
    By breadCrumbElements = By.xpath("//ul[@class='m-breadcrumb-list']//a");
    By inputMinPriceFilter = By.id("min-price-filter");
    By inputMaxPriceFilter = By.id("max-price-filter");
    By filterPriceButton = By.xpath("//div[@class='a-price__filterButton']");
    By seeMoreBrandButton = By.className("a-link__viewMore");
    By seeMoreSizeButton = By.xpath("(//a[contains(text(),'Ver más')])[18]");

    By firstProduct = By.xpath("(//article[@class='d-flex ipod-d-block'])[1]");


    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyTextFromNullLabel(){
        return driver.findElement(nullProductLabel).getText();
    }

    public boolean searchStringInBreadcrumb(String text){
        List<WebElement> elements = driver.findElements(breadCrumbElements);
        boolean status = false;
        for(WebElement element: elements){
            //System.out.print(element.getText());
            if(element.getText().equals(text)){
                status = true;
                break;
            }

        }
        return status;
    }

    public void setPriceRange(int min,int max){
        driver.findElement(inputMinPriceFilter).sendKeys(Integer.toString(min));
        driver.findElement(inputMaxPriceFilter).sendKeys(Integer.toString(max));
        driver.findElement(filterPriceButton).click();

    }

    public void selectBrandFilter(String brand){

        driver.findElement(By.id("brand-"+brand)).click();
    }

    public void selectSizeFilter(String size){

        driver.findElement(By.id("variants.normalizedSize-"+size)).click();
    }

    public void clickFirstProduct(){
        driver.findElement(firstProduct).click();
    }


}
