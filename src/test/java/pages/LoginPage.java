package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By email = By.id("username");
    By password = By.id("password");

    By loginButton = By.xpath("//button[@class='c1d51edb7 c3e1f488b cac1b9771 c2a64c88b c9d62625d']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void performLogin(String user,String pwd){
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginButton).click();
    }
}
