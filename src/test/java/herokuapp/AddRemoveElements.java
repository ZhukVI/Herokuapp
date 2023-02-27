package herokuapp;

import framework.BaseTest;
import framework.Browser;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class AddRemoveElements extends BaseTest {

    private static final String  NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final String ADD_REMOVE_BUTTON = "//button[contains(text(), '%s')]";

    @Test
    void addRemoveElementsTest(){
        Label addRemoveElements = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Add/Remove Elements")));
        addRemoveElements.clickAndWait();
        WebDriver driver1 = Browser.getDriver();

        Label addButton = new Label(By.xpath(String.format(ADD_REMOVE_BUTTON, "Add Element")));
        addButton.click();
        addButton.click();

        Label deleteButton = new Label(By.xpath(String.format(ADD_REMOVE_BUTTON, "Delete")));
        deleteButton.click();

        List<WebElement> labels = driver1.findElements(By.xpath(String.format(ADD_REMOVE_BUTTON, "Delete")));
        System.out.println(labels.size());
    }
}
