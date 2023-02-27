package herokuapp;

import framework.BaseTest;
import framework.Browser;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hovers extends BaseTest {

    private static final String NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final String AVATAR_LIST = "//img[@alt = 'User Avatar']";


    @Test
    void inputsTest() {
        Label dropdownPage = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Hovers")));
        dropdownPage.clickAndWait();
        WebDriver driver1 = Browser.getDriver();

        List<WebElement> avatars = driver1.findElements(By.xpath(AVATAR_LIST));
        List<WebElement> links = driver1.findElements(By.xpath("//a[contains(text(), 'View profile')]"));


        for (int i = 0; i < avatars.size(); i++){
            WebElement avatar = avatars.get(i);
            WebElement link = links.get(i);
            Actions action = new Actions(driver1);
            action.moveToElement(avatar).moveToElement(link).click().perform();
            System.out.println(driver1.findElement(By.tagName("h1")).getText());
            driver1.navigate().back();
        }

    }
}
