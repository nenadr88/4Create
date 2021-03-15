package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import variables.Paths;

public class DriverWrapper {
    private String driverType = "chrome";

    private WebDriver createDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                return createChromeDriver();
            case "firefox":
            case "safari":
            case "ie":
            default:
                return null;
        }
    }

    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Paths.CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    public WebDriver getDriver() {
        return createDriver(driverType);
    }
}
