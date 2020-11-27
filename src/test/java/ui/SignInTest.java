package ui;

import org.junit.Assert;
import org.testng.annotations.Test;
import ui.pages.home.HomePage;
import ui.pages.member.MemberHomePage;
import ui.pages.signIn.SignInPage;

import static ui.pages.home.HomePage.getHomePage;
import static ui.pages.member.MemberHomePage.getMemberHomePage;
import static ui.pages.signIn.SignInPage.getSignInPage;

public class SignInTest extends BaseTestCase {
    HomePage homePage = getHomePage();
    SignInPage signInPage = getSignInPage();
    MemberHomePage memberHomePage = getMemberHomePage();

    @Test(enabled = false)
    public void signIn()
    {
        homePage.header().requestSignIn();
        signInPage.act().signIn("wizetest1@gmail.com", "autotest");
        memberHomePage.verify().signInOk();
    }

    @Test
    public void signOut()
    {
        if (homePage.header().isSignedUser()) {
            homePage.header().signOut();
            Assert.assertFalse(homePage.header().isSignedUser());
        }
    }
}

