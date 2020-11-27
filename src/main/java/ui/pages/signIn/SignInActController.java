package ui.pages.signIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtil;

import static ui.DriverFactory.startChromeDriver;
import static ui.DriverFactory.waitForPageLoad;

public class SignInActController {
    WebDriver driver = startChromeDriver();

    @FindBy(id="user_email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="user_password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name="commit")
    @CacheLookup
    WebElement btnSubmit;

    public SignInActController() {
        PageFactory.initElements(this.driver, this);
    }

    public void signIn(String username, String password) {
        waitForPageLoad(10);
        WebElementUtil.inputText(txtEmail, username);
        WebElementUtil.inputText(txtPassword, password);
        btnSubmit.click();
    }
}
