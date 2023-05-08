package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;
    By productTitleLabel = By.xpath("//h1[@class='a-product__information--title']");
    By productPrizeLabel = By.xpath("//p[@class='a-product__paragraphDiscountPrice m-0 d-inline ']");
    By productSizeButton = By.xpath("//button[@class='a-btn a-btn--actionpdp active']");
    By buyNowButton = By.id("opc_pdp_buyNowButton");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validateProductTitleContainsBrand(String brand){

        String productTitle = driver.findElement(productTitleLabel).getText().toUpperCase();

        return productTitle.contains(brand);
    }

    public boolean validateProductPrizeBetweenRange(float min, float max){
        String productPrize = driver.findElement(productPrizeLabel).getText();
        productPrize = productPrize.replaceAll("[^0-9]", "");
        StringBuilder prize = new StringBuilder(productPrize).insert(productPrize.length() - 2,".");
        float prizeFloat = Float.parseFloat(String.valueOf(prize));
        boolean status = (prizeFloat >= min) && (prizeFloat <= max);
        return status;
    }

    public boolean validateProductSize(String size){
        return driver.findElement(productSizeButton).getText().equals(size);
    }

    public void clickOnBuyButton(){
        driver.findElement(buyNowButton).click();
    }

    public String getProductTitle(){
        return driver.findElement(productTitleLabel).getText();
    }

}
