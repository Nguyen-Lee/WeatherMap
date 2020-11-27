package ui.pages.member;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ui.DriverFactory.*;

public class MemberHomeActController {
    WebDriver driver = startFireFoxDriver();

    @FindBy(xpath = "//*[@id='myTab']/li[3]/a")
    @CacheLookup
    WebElement apiKeysTab;

    public MemberHomeActController() {
        PageFactory.initElements(this.driver, this);
    }

    public void goToApiKeysPage() {
        waitForPageLoad(10);
        clickElementAsReady(apiKeysTab, 10);
    }
}

