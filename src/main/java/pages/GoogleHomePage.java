package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@name='q']")
    private WebElement txt_googleSearch;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleHomePage enterSearchTerm(String searchTerm){
        log.debug("enterSearchTerm(" + searchTerm + ");");
        enterText(txt_googleSearch, searchTerm);
        return new GoogleHomePage(driver);
    }

    public GoogleSearchResultsPage clickGoogleSearch(){
        log.debug("clickGoogleSearch();");
        enterText(txt_googleSearch, String.valueOf(Keys.RETURN));
        return new GoogleSearchResultsPage(driver);
    }

}
