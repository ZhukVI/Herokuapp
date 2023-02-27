package herokuapp;

import framework.BaseTest;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Inputs extends BaseTest {
    private static final String  NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final TextBox TEXT_FIELD_NUMBER = new TextBox(By.xpath("//input"));


    @Test
    void inputsTest() {
        Label dropdownPage = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Inputs")));
        dropdownPage.clickAndWait();

        TEXT_FIELD_NUMBER.sendKeys(Keys.ARROW_UP);
        TEXT_FIELD_NUMBER.sendKeys(Keys.ARROW_UP);
        TEXT_FIELD_NUMBER.sendKeys(Keys.ARROW_UP);
        TEXT_FIELD_NUMBER.sendKeys(Keys.ARROW_UP);
        System.out.println(TEXT_FIELD_NUMBER.getAttribute("value"));
        TEXT_FIELD_NUMBER.sendKeys(Keys.ARROW_DOWN);
        System.out.println(TEXT_FIELD_NUMBER.getAttribute("value"));
        TEXT_FIELD_NUMBER.clearField();
        TEXT_FIELD_NUMBER.sendStringKeys("7");
        System.out.println(TEXT_FIELD_NUMBER.getAttribute("value"));
        TEXT_FIELD_NUMBER.clearField();
        TEXT_FIELD_NUMBER.sendStringKeys("a");
        System.out.println(TEXT_FIELD_NUMBER.getAttribute("value"));

    }
}
