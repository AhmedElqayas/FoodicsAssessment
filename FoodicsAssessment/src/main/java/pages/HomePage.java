package pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends PageBase {
    private final By signInButton = By.xpath("//*[text()='Hello, sign in']");
    private final By allButton = By.xpath("//*[@class='hm-icon-label' and text()='All']");
    private final By seeAllButton = By.xpath("//*[@aria-label='See All Categories']");
    private final By sideMenu = By.id("hmenu-content");
    private final By videoGamesButton = By.xpath("//div[text()='Video Games']");
    private final By allVideoGamesButton = By.xpath("(//a[text()='All Video Games'])[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        click(signInButton);
    }

    public void goToAllVideoGames() {
        click(allButton);
        click(seeAllButton);
        scrollToElementInMenu(sideMenu, videoGamesButton);
        click(videoGamesButton);
        click(allVideoGamesButton);
    }
}
