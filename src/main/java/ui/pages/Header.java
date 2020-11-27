package ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ui.DriverFactory.*;

public class Header {
    WebDriver driver = startFireFoxDriver();
    private static Logger logger = LogManager.getLogger(Header.class);

    @FindBy(id="sign_in")
    @CacheLookup
    WebElement liSignIn;

    @FindBy(id="signed-user")
    @CacheLookup
    WebElement liUsername;

    @FindBy(xpath = "//*[@id='dropdown_menu']/li/a[@class='logout']")
    WebElement liSignOut;

    public Header()
    {
        PageFactory.initElements(this.driver, this);
    }

    public boolean isSignedUser() {
        boolean result = true;
        try {
            result = liUsername.isDisplayed();
        }catch (NoSuchElementException ex) {
            result = false;
        }
        return result;
    }

    public void requestSignIn() {
        logger.info("Redirect to Sign In page");
        try {
            liSignIn.click();
            isExpectedUrl(UIParams.URL_SIGNIN);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    public void signOut() {
        liSignOut.click();
    }
}
