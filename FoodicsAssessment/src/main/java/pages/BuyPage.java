package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuyPage extends PageBase {
    private final By addNewAddressButton = By.id("add-new-address-desktop-sasp-tango-link");
    private final By addressFullName = By.id("address-ui-widgets-enterAddressFullName");
    private final By addressPhone = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By addressStreet = By.id("address-ui-widgets-enterAddressLine1");
    private final By addressBuilding = By.id("address-ui-widgets-enter-building-name-or-number");
    private final By addressCityField = By.id("address-ui-widgets-enterAddressCity");
    private final By addressCity = By.id("address-ui-widgets-autoCompleteResult-0");
    private final By addressDistrictField = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private final By addressDistrict = By.id("address-ui-widgets-autoCompleteResult-0");
    private final By addressLandmark = By.id("address-ui-widgets-landmark");
    private final By addressType = By.id("address-ui-widgets-addr-details-res-radio-input");
    private final By useThisAddressButton = By.id("checkout-primary-continue-button-id-announce");
    private final By orderSummary = By.className("order-summary-line-definition");

    public BuyPage(WebDriver driver) {
        super(driver);
    }

    public void addAddress() {
        click(addNewAddressButton);
        enterText(addressFullName, "Ahmed Mohamed");
        enterText(addressPhone, "01093620000");
        enterText(addressStreet, "test");
        enterText(addressBuilding, "test1");
        enterText(addressCityField, "cairo");
        click(addressCity);
        enterText(addressDistrictField, "");
        click(addressDistrict);
        enterText(addressLandmark, "market");
        click(addressType);
        click(useThisAddressButton);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateOrderSummary() {
        Assert.assertEquals(Double.parseDouble(getText(orderSummary).replaceAll("[^\\d.]", "")), AllVideoGamesPage.totalPrice);
    }
}
