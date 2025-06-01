package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllVideoGamesPage extends PageBase {
    private final By freeShippingButton = By.xpath("//*[@dir='auto' and text()='Free Shipping']");
    private final By filterButton = By.id("s-all-filters-announce");
    private final By filterMenu = By.id("s-refinements");
    private final By newCondition = By.xpath("//*[text()='New']");
    private final By goToBasketButton = By.xpath("//*[@id='ewc-compact-actions-container']/div/div[2]/span");
    public static int totalItems;
    public static double totalPrice;

    public AllVideoGamesPage(WebDriver driver) {
        super(driver);
    }

    public void applyFilters() {
        click(freeShippingButton);
        scrollToElementInMenu(filterMenu, newCondition);
        click(newCondition);
    }

    public void addElementToCart(double priceLimit) {
        int itemsCount = driver.findElements(By.xpath("//*[@role='listitem']")).size();

        for (int i = 1; i <= itemsCount; i++) {
            String index = ((Integer) (i + 1)).toString();
            try {
                By addToCartLocator = By.xpath("//*[@role='listitem' and @data-index='" + index + "']//*[@name='submit.addToCart']");
                scrollToElement(addToCartLocator);

                String priceWhole = "(//*[@class='a-price-whole'])";
                String priceFraction = "(//*[@class='a-price-fraction'])";
                String price = getText(By.xpath(priceWhole + "[" + ((Integer) i).toString() + "]")) + "." + getText(By.xpath(priceFraction + "[" + ((Integer) i).toString() + "]"));
                double itemPrice = Double.parseDouble(price);
                System.out.println(itemPrice);

                if (itemPrice < priceLimit) {
                    totalPrice += itemPrice;
                    totalItems++;
                    click(addToCartLocator);
                }

            } catch (Exception e) {
                System.out.println("Not found for: " + i);
            }
        }
    }

    public void goToCartPage() {
        click(goToBasketButton);
    }
}
