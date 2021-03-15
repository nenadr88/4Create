package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class YahooMailPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@data-test-folder-name='Inbox']")
    private WebElement link_inbox;
    @FindBy(how = How.ID, using = "ybarAccountMenuOpener")
    private WebElement label_accountName;
    @FindBy(how = How.XPATH, using = "//a[@data-soa='Sign out all']")
    private WebElement span_signOut;

    public YahooMailPage(WebDriver driver) {
        super(driver);
    }

    public YahooMailPage verifyUnreadEmails(){
        log.debug("verifyUnreadEmails();");
        Assert.assertNotEquals(getAttributeFromElement(link_inbox, "data-test-unread-count"), "0");
        return new YahooMailPage(driver);
    }

    public YahooMailPage clickOnAccount(){
        log.debug("clickOnAccount();");
        clickOnElement(label_accountName);
        return new YahooMailPage(driver);
    }

    public YahooHomePage clickOnLogout(){
        log.debug("clickOnLogout();");
        clickOnElement(span_signOut);
        return new YahooHomePage(driver);
    }
}
