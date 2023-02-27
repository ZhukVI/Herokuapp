package herokuapp;

import framework.BaseTest;
import framework.Browser;
import framework.elements.Combobox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownElements extends BaseTest {
    private static final String  NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final Combobox DROPDOWN_LIST = new Combobox(By.xpath("//select"));

    @Test
    void dropdownTest() {
        Label dropdownPage = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Dropdown")));
        dropdownPage.clickAndWait();
        WebDriver driver1 = Browser.getDriver();

        DROPDOWN_LIST.click();
        List<WebElement> options = driver1.findElements(By.tagName("option"));
        System.out.println(options.size());
        Actions option1 = new Actions(driver1);
        option1.moveToElement(options.get(1));
        DROPDOWN_LIST.selectComboBox("Option 1");
        options.get(1).isSelected();
        option1.moveToElement(options.get(2));
        DROPDOWN_LIST.selectComboBox("Option 2");
        options.get(2).isSelected();
    }
}
