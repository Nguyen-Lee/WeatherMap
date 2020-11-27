package ui.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static ui.DriverFactory.startFireFoxDriver;

public class HomeActController {
    WebDriver driver = startFireFoxDriver();

    public HomeActController()
    {
        PageFactory.initElements(this.driver, this);
    }



}
