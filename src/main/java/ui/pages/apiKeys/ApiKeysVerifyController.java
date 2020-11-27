package ui.pages.apiKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static ui.DriverFactory.startFireFoxDriver;

public class ApiKeysVerifyController {
    WebDriver driver = startFireFoxDriver();

    @FindBy(xpath = "(//table[@class='material_table api-keys']/tbody/tr)[last()]")
    WebElement lastRowApiKey;

    String keyLocator = "//table[@class='material_table api-keys']/tbody/tr/td[1][text()=%s]";

    public ApiKeysVerifyController() {
        PageFactory.initElements(driver, this);
    }

    public void lastRowHasExpectedName(String value) {
        WebElement nameCol = lastRowApiKey.findElement(By.xpath("td[2]"));
        Assert.assertEquals(nameCol.getText(), value);
    }

    public boolean existedKey(String value) {
        boolean isExisted = true;
        try {
            driver.findElement(By.xpath(String.format(keyLocator, value)));
        } catch (NoSuchElementException ex) {
            isExisted = false;
        }
        return isExisted;
    }

    public void deleteSuccessfully (String key) {
        Assert.assertFalse(existedKey(key));
    }
}
