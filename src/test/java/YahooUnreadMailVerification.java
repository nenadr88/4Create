import core.DriverWrapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.YahooHomePage;
import variables.EnvVariables;
import variables.TestData;

public class YahooUnreadMailVerification extends BaseTest {

    YahooHomePage yahooHomePage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = new DriverWrapper().getDriver();
        driver.get(EnvVariables.GMAIL_URL);
        driver.manage().window().maximize();
        yahooHomePage = new YahooHomePage(driver);
    }

    @Test
    public void yahooUnreadMailVerification(){
        yahooHomePage.clickSignInButton()
                .enterEmail(TestData.EMAIL_ADDRESS)
                .clickNextAfterType()
                .enterPassword(TestData.PASSWORD)
                .clickOnNextButton()
                .clickOnMailLink()
                .verifyUnreadEmails()
                .clickOnAccount()
                .clickOnLogout()
                .verifyPresenceOfSignInButton();
    }
}
