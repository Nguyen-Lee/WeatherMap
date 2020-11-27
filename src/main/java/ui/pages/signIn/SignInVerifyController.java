package ui.pages.signIn;

import org.openqa.selenium.WebDriver;
import ui.pages.UIParams;

import static ui.DriverFactory.*;

public class SignInVerifyController {
    WebDriver driver = startFireFoxDriver();
    public void isFailedSignIn() {
        waitForPageLoad(5);
    }

    public void isSignInOk() {
        waitForPageLoad(5);
        isExpectedUrl(UIParams.URL_MEMBER_HOMEPAGE);
    }
}
