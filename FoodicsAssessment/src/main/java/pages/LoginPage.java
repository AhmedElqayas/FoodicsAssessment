package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private final By emailOrPhoneField = By.id("ap_email_login");
    private final By continueButton = By.xpath("//*[@type='submit']");
    private final By passwordField = By.id("ap_password");
    private final By signInButton = By.id("signInSubmit");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterPhoneAndContinue(String phone) {
        enterText(emailOrPhoneField, phone);
        click(continueButton);
    }

    public void enterPasswordAndSignIn(String password) {
        enterText(passwordField, password);
        click(signInButton);
    }
}
