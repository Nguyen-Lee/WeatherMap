package ui.pages.home;

import ui.pages.Header;

public class HomePage {
    Header header ;

    private HomeActController actController;
    private HomeVerifyController verifyController;


    public HomeActController act() {
        return this.actController;
    }

    public HomeVerifyController verify() {
        return this.verifyController;
    }

    private HomePage(HomeActController act, HomeVerifyController verify) {
        this.actController = act;
        this.verifyController = verify;
        this.header = new Header();
    }

    public static HomePage getHomePage() {
        return new HomePage(new HomeActController(), new HomeVerifyController());
    }

    public Header header() {
        return this.header;
    }
}
