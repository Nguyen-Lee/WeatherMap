package ui.pages.apiKeys;

public class ApiKeysPage {
    ApiKeysActController actController;
    ApiKeysVerifyController verifyController;

    public ApiKeysActController act() {
        return this.actController;
    }

    public ApiKeysVerifyController verify() {
        return this.verifyController;
    }

    private ApiKeysPage(ApiKeysActController actController, ApiKeysVerifyController verifyController) {
        this.actController = actController;
        this.verifyController = verifyController;
    }

    public static ApiKeysPage getApiKeyPage() {
        return new ApiKeysPage(new ApiKeysActController(), new ApiKeysVerifyController());
    }
}