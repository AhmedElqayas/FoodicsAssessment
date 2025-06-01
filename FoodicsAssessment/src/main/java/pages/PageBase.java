package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }
    protected void click(By elementLocator) {
        getElement(elementLocator).click();
    }
    protected void enterText(By elementLocator, String text) {
        getElement(elementLocator).sendKeys(text);
    }
    protected String getText(By elementLocator) {
        return getElement(elementLocator).getText();
    }
    protected void selectFromDropdownList(By dropdownListLocator, String choice) {
        click(dropdownListLocator);
        click(By.xpath("//*[text()='" + choice + "']"));
    }
    protected void scrollToElementInMenu(By menu, By item) {
        WebElement menuElement = driver.findElement(menu);
        WebElement targetItem = driver.findElement(item);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", menuElement, targetItem);
    }
    protected void scrollToElement(By elementLocator) {
        WebElement targetElement = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", targetElement);
    }
    protected void scrollUpToElement(By elementLocator) {
        WebElement targetElement = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'start', inline: 'nearest'});", targetElement);    }
}
