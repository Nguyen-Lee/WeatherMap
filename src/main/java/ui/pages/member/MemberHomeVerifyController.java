package ui.pages.member;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pages.Header;
import ui.pages.UIParams;

import static ui.DriverFactory.*;

public class MemberHomeVerifyController {
    WebDriver driver = startFireFoxDriver();
    Header header;

    String msgSignInLocator = "//div[@class='panel-body'][contains(text(), '%s')]";

    public void signInOk() {
        waitForPageLoad(10);
        Assert.assertTrue(isExpectedUrl(UIParams.URL_MEMBER_HOMEPAGE));
        msgSignInLocator = String.format(msgSignInLocator, UIParams.MSG_SIGN_IN_OK);
        waitForElement(By.xpath(msgSignInLocator), 5);
    }
}
