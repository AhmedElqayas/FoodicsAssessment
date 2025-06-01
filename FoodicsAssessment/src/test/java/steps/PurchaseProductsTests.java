package steps;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class PurchaseProductsTests extends TestBase {
    private final LaunchingPage launchingPage;
    private final HomePage homePage;
    private final LoginPage loginPage;
    private final AllVideoGamesPage allVideoGamesPage;
    private final CartPage cartPage;
    private final BuyPage buyPage;
    public PurchaseProductsTests() {
        setup();
        launchingPage = new LaunchingPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        allVideoGamesPage = new AllVideoGamesPage(driver);
        cartPage = new CartPage(driver);
        buyPage = new BuyPage(driver);
    }

    @Given("the user goes to home page")
    public void launchHomePage() {
        launchingPage.goToHomePage();
    }

    @And("the user login with {string} and {string}")
    public void theUserLoginSuccessfully(String phone, String password) {
        homePage.goToLoginPage();
        loginPage.enterPhoneAndContinue(phone);
        loginPage.enterPasswordAndSignIn(password);
    }

    @And("the user goes to all video games page")
    public void theUserGoesToAllVideoGamesPage() {
        homePage.goToAllVideoGames();
    }

    @When("the user apply some filters")
    public void theUserApplySomeFilters() {
        allVideoGamesPage.applyFilters();
    }

    @And("the user selects items with price lower that {string}")
    public void theUserSelectsItemsWithPriceLowerThat(String priceLimit) {
        allVideoGamesPage.addElementToCart(Double.parseDouble(priceLimit));
    }

    @And("the user goes cart")
    public void theUserGoesCart() {
        allVideoGamesPage.goToCartPage();
    }

    @Then("all items should be added successfully")
    public void allItemsShouldBeAddedSuccessfully() {
        cartPage.validateAllItemsAdded();
    }

    @When("the user goes to buy page")
    public void theUserGoesToBuyPage() {
        cartPage.goToBuyPage();
    }

    @And("the user adds address")
    public void theUserAddsAddress() {
        buyPage.addAddress();
    }

    @Then("total amount should be correct")
    public void totalAmountShouldBeCorrect() {
        buyPage.validateOrderSummary();
    }
}
