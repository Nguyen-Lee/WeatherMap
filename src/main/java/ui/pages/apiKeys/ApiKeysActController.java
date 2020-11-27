package ui.pages.apiKeys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtil;

import static ui.DriverFactory.*;

public class ApiKeysActController {
    WebDriver driver = startFireFoxDriver();
    private static Logger logger = LogManager.getLogger(ApiKeysVerifyController.class);

    @FindBy(id="api_key_form_name")
    @CacheLookup
    WebElement txtKeyName;

    @FindBy(name="commit")
    @CacheLookup
    WebElement btnGenerate;

    @FindBy(xpath = "(//table[@class='material_table api-keys']/tbody/tr)[last()]")
    WebElement apiKeyLastRow;

    String keyColumnLocator = "//table[@class='material_table api-keys']/tbody/tr/td[1]/pre[text()='%s']";

    @FindBy(id="edit_key_form_name")
    WebElement txtOldName;

    @FindBy(xpath = "//*[@id='edit_key_modal']/div/div[3]/button[2]")
    WebElement btnUpdate;

    public ApiKeysActController() {
        PageFactory.initElements(driver, this);
    }

    public void createKey(String value) {
        WebElementUtil.inputText(txtKeyName, value);
        btnGenerate.click();
    }

    public String getKeyOfLastRow() {
        return apiKeyLastRow.findElement(By.xpath("td[1]")).getText();
    }

    private WebElement findRowElementByKey(String key)
    {
        keyColumnLocator = String.format(keyColumnLocator, key);
        logger.info("Looking for key locator: " + keyColumnLocator);
        WebElement foundKeyElement = driver.findElement(By.xpath(keyColumnLocator));

        WebElement rowElement = foundKeyElement.findElement(By.xpath("./../.."));
        logger.info("Row element: " + rowElement.getTagName());
        return rowElement;
    }

    public void updateNameByKey(String key, String newName) {
       WebElement rowElement = findRowElementByKey(key);

        WebElement actionElement = rowElement.findElement(By.xpath("td[3]/a[1]"));
        actionElement.click();

        String mainWindow = driver.getWindowHandle();
        WebElement activeElement = driver.switchTo().activeElement();
        logger.info(activeElement.getTagName());
        
        WebElementUtil.inputText(txtOldName, newName);
        btnUpdate.click();

        driver.switchTo().window(mainWindow);
    }

    public void deleteByKey(String key) throws InterruptedException {
        try {
            WebElement rowElement = findRowElementByKey(key);
            WebElement actionElement = rowElement.findElement(By.xpath("td[3]/a[2]"));

            String mainWindow = driver.getWindowHandle();
            actionElement.click();
            Alert alert = waitForAlert(5);
            alert.accept();
            driver.switchTo().window(mainWindow);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}
