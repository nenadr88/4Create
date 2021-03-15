import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
