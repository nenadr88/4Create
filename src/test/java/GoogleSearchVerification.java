import core.DriverWrapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import variables.EnvVariables;
import variables.TestData;

public class GoogleSearchVerification extends BaseTest {

    GoogleHomePage googleHomePage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = new DriverWrapper().getDriver();
        driver.get(EnvVariables.BASE_URL);
        driver.manage().window().maximize();
        googleHomePage = new GoogleHomePage(driver);
    }

    @Test
    public void googleSearchVerification(){
        googleHomePage.enterSearchTerm(TestData.GOOGLE_SEARCH_TERM)
                .clickGoogleSearch()
                .verifyFirstSearchResult(TestData.GOOGLE_RESULT_EMAIL_ADDRESS, TestData.GOOGLE_RESULTS_SEO_NAME);
    }
}
