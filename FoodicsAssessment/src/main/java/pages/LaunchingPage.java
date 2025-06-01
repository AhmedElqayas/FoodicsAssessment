package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaunchingPage extends PageBase {
    private final By yourAccountLink = By.xpath("//*[text()='Your Account']");

    public LaunchingPage(WebDriver driver) {
        super(driver);
    }
    public void goToHomePage() {
        click(yourAccountLink);
    }
}
