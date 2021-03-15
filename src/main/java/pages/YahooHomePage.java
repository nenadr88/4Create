package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class YahooHomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    private WebElement input_username;
    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement input_password;
    @FindBy(how = How.XPATH, using = "//a[contains(@data-redirect-params, 'signin')]")
    private WebElement sign;
    @FindBy(how = How.ID, using = "login-signin")
    private WebElement button_signin;
    @FindBy(how = How.ID, using = "ybarMailLink")
    private WebElement link_mail;
    @FindBy(how = How.XPATH, using = "//span[@class='E_fq7 T_eDQ']")
    private WebElement span_unreadEmailClass;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    public YahooHomePage enterEmail(String searchTerm){
        log.debug("enterEmail(" + searchTerm + ");");
        enterText(input_username, searchTerm);
        return new YahooHomePage(driver);
    }

    public YahooHomePage clickSignInButton(){
        log.debug("clickSignInButton();");
        clickOnElement(sign);
        return new YahooHomePage(driver);
    }

    public YahooHomePage clickNextAfterType(){
        log.debug("clickNextAfterType();");
        enterText(input_username, String.valueOf(Keys.RETURN));
        return new YahooHomePage(driver);
    }

    public YahooHomePage enterPassword(String searchTerm){
        log.debug("enterPassword(" + searchTerm + ");");
        enterText(input_password, searchTerm);
        return new YahooHomePage(driver);
    }

    public YahooHomePage clickOnNextButton(){
        log.debug("clickNextButton();");
        clickOnElement(button_signin);
        return new YahooHomePage(driver);
    }

    public YahooMailPage clickOnMailLink(){
        log.debug("clickOnMailLink();");
        clickOnElement(link_mail);
        return new YahooMailPage(driver);
    }

    public YahooHomePage verifyPresenceOfSignInButton() {
        log.debug("verifyPresenceOfSignInButton();");
        Assert.assertTrue(waitForElement(sign).isDisplayed());
        return new YahooHomePage(driver);
    }

}
