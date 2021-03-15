package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class GoogleSearchResultsPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//div[@class='g'][1]")
    private WebElement div_firstSearchResult;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchResultsPage verifyFirstSearchResult(String mail, String seoName){
        log.debug("verifyFirstSearchResult(" + mail + " | " + seoName + ");");
        Assert.assertTrue(getTextFromElement(div_firstSearchResult).contains(mail) &&
                getTextFromElement(div_firstSearchResult).contains(seoName)
        );
        return new GoogleSearchResultsPage(driver);
    }
}
