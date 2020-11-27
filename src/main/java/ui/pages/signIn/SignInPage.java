package ui.pages.signIn;

public class SignInPage {
    private SignInActController actController;
    private SignInVerifyController verifyController;

    public SignInActController act() {
        return this.actController;
    }

    public SignInVerifyController verify() {
        return this.verifyController;
    }

    private SignInPage(SignInActController act, SignInVerifyController verify) {
        this.actController = act;
        this.verifyController = verify;
    }

    public static SignInPage getSignInPage() {
        return new SignInPage(new SignInActController(), new SignInVerifyController());
    }
}
