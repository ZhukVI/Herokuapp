package framework.elements;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    private By by;
    private String name;


    public BaseElement(By by) {
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected abstract String getElementType();
    public boolean isElementPresent() {
        try {
            Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            System.out.println(getElementType() + ": " + by + " - is present");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(getElementType() + ": " + by + " - is not present. Exception - NoSuchElementException");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return false;
    }

    public WebElement getElement() {
        isElementPresent();
        return element;
    }

    public boolean isDisplayed() {
        isElementPresent();
        return element.isDisplayed();
    }

    public void clickAndWait() {
        isElementPresent();
        element.click();
        Browser.getTimeoutForPageLoad();
    }

    public void click() {
        isElementPresent();
        element.click();
        Browser.getTimeoutForCondition();
    }

    public boolean isSelected() {
        isElementPresent();
        return element.isSelected();
    }

    public void moveToElement() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).perform();
    }

    public void selectComboBox(String value) {
        isElementPresent();
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void sendKeys(Keys sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
    }
    public void sendStringKeys(String sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
    }

    public String getAttribute(String attribute) {
        isElementPresent();
        return element.getAttribute(attribute);
    }

    public void clearField() {
        isElementPresent();
        getElement().clear();
    }

    public void moveAndClickByAction() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click().build().perform();
    }
}
