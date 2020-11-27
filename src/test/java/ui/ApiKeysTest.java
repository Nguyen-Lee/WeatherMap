package ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.apiKeys.ApiKeysPage;
import ui.pages.member.MemberHomePage;

import static ui.pages.apiKeys.ApiKeysPage.getApiKeyPage;
import static ui.pages.member.MemberHomePage.getMemberHomePage;

public class ApiKeysTest extends BaseTestCase {
    ApiKeysPage apiKeys = getApiKeyPage();
    MemberHomePage memberHomePage = getMemberHomePage();
    String name = "Nguyen Lee test";

    @BeforeClass
    public void setup() {
        memberHomePage.act().goToApiKeysPage();
    }

    @Test
    public void createApiKey() {
        apiKeys.act().createKey(name);
        apiKeys.verify().lastRowHasExpectedName(name);
    }

    @Test (dependsOnMethods = "createApiKey")
    public void updateApiKey() {
        String key = apiKeys.act().getKeyOfLastRow();
        String newName = "Updated - Nguyen Le";
        apiKeys.act().updateNameByKey(key, newName);
        apiKeys.verify().lastRowHasExpectedName(newName);
    }

    @Test (dependsOnMethods = "updateApiKey")
    public void deleteApiKey() throws InterruptedException {
        String key = apiKeys.act().getKeyOfLastRow();
        apiKeys.act().deleteByKey(key);
        apiKeys.verify().deleteSuccessfully(key);
    }
}