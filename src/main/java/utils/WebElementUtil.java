package utils;

import org.openqa.selenium.WebElement;

public class WebElementUtil {
    public static void inputText(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }
}
