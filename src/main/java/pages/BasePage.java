package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    public final Logger log = LogManager.getLogger(this.getClass());

    public BasePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElement(WebElement element ){
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element)
        ));
        return element;
    }

    protected WebElement enterText(WebElement element, String text) {
        waitForElement(element).sendKeys(text);
        return element;
    }

    protected WebElement clickOnElement(WebElement element) {
        waitForElement(element).click();
        return element;
    }

    protected String getAttributeFromElement(WebElement element, String attributeName) {
        return waitForElement(element).getAttribute(attributeName);
    }

    protected String getTextFromElement(WebElement element){
        return waitForElement(element).getText();
    }
}
