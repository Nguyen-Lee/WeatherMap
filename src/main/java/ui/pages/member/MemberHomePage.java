package ui.pages.member;

import ui.pages.Header;

public class MemberHomePage {
    Header header;
    MemberHomeActController actController;
    MemberHomeVerifyController verifyController;

    public MemberHomeActController act() {
        return this.actController;
    }

    public MemberHomeVerifyController verify() {
        return verifyController;
    }

    private MemberHomePage(MemberHomeActController actController, MemberHomeVerifyController verifyController) {
        this.actController = actController;
        this.verifyController = verifyController;
    }

    public static MemberHomePage  getMemberHomePage() {
        return new MemberHomePage(new MemberHomeActController(), new MemberHomeVerifyController());
    }
}
