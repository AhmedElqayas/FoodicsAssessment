package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends PageBase {
    private final By totalItemsLabel = By.id("sc-subtotal-label-activecart");
    private final By totalAmountLabel = By.id("sc-subtotal-amount-activecart");
    private final By proceedToBuyButton = By.xpath("//*[@name='proceedToRetailCheckout']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void validateAllItemsAdded() {
        scrollToElement(totalItemsLabel);
        int totalItems = Integer.parseInt(getText(totalItemsLabel).replaceAll("\\D+", ""));
        System.out.println(totalItems);
        Assert.assertEquals(totalItems, AllVideoGamesPage.totalItems);
    }

    public void goToBuyPage() {
        scrollUpToElement(proceedToBuyButton);
        click(proceedToBuyButton);
    }
}
