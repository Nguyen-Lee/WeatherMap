package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    private DriverFactory(){
        // prevent instantiation
    }

    public static WebDriver startChromeDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver startFireFoxDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver startIEDriver() {
        if (driver == null) {
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public static WebDriver startEdgeDriver() {
        if (driver == null) {
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait(long timeout) {
        if (wait == null) {
            wait = new WebDriverWait(driver, timeout);
        }
        return wait;
    }

    public static void waitForElement(WebElement element, long timeout) {
        logger.info(String.format("Wait element '%s' in %s seconds", element.getTagName(), timeout));
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElement(By locator, long timeout) {
        logger.info(String.format("Wait element has locator '%s' in %s seconds", locator, timeout));
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public static void waitForElementEnabled(WebElement element, long timeout) {
        logger.info(String.format("Wait element '%s' in %s seconds", element.getTagName(), timeout));
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void clickElementAsReady(WebElement element, long timeout) {
        logger.info(String.format("Wait element has locator '%s' in %s seconds", element.getTagName(), timeout));
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForPageLoad(long timeout) {
        logger.info(String.format("Wait for page %s load", driver.getCurrentUrl()));
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete' ? true : false"));
    }

    public static Alert waitForAlert(long timeout)
    {
        wait = getWebDriverWait(timeout);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public static boolean isExpectedUrl(String expectedUrl)
    {
        String currentUrl = driver.getCurrentUrl().replaceAll("/$", "");
        expectedUrl = driver.getCurrentUrl().replaceAll("/$", "");
        return currentUrl.equalsIgnoreCase(expectedUrl);
    }
}
