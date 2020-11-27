package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.pages.home.HomePage;
import ui.pages.member.MemberHomePage;
import ui.pages.signIn.SignInPage;
import utils.ConfigUtils;

import static org.openqa.selenium.remote.BrowserType.*;
import static ui.DriverFactory.*;
import static ui.pages.home.HomePage.getHomePage;
import static ui.pages.member.MemberHomePage.getMemberHomePage;
import static ui.pages.signIn.SignInPage.getSignInPage;

public class BaseTestCase {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTestCase.class);

    @BeforeSuite
    public void setupBrowser() {
        try {
            switch (ConfigUtils.getExpectedBrowser()) {
                case FIREFOX:
                    this.driver = startFireFoxDriver();
                    break;

                case IE:
                    driver = startIEDriver();
                    break;

                case EDGE:
                    this.driver = startEdgeDriver();
                    break;

                default:
                    this.driver = startChromeDriver();
                    break;
            }
            openBaseUrl();
            login();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    private void login() {
        HomePage homePage = getHomePage();
        if (!homePage.header().isSignedUser()) {
            SignInPage signInPage = getSignInPage();
            MemberHomePage memberHomePage = getMemberHomePage();

            homePage.header().requestSignIn();

            signInPage.act().signIn("wizetest1@gmail.com", "autotest");
            memberHomePage.verify().signInOk();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        this.driver.quit();
    }

    public void openBaseUrl() {
        logger.info("Start url: " + ConfigUtils.getBaseUrl());
        this.driver.get(ConfigUtils.getBaseUrl());
        waitForPageLoad(ConfigUtils.getLongTimeoutSecond());
        this.driver.manage().window().maximize();
    }
}