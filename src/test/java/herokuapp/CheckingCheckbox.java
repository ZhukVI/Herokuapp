package herokuapp;

import framework.BaseTest;
import framework.elements.Combobox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CheckingCheckbox extends BaseTest {
    private static final String  NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final Combobox CHECKBOX_LIST = new Combobox(By.xpath("//input"));

    @Test
    void checkboxTest() {
        Label checkboxesPage = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Checkboxes")));
        checkboxesPage.clickAndWait();

        List<WebElement> checkboxes = CHECKBOX_LIST.getElement().findElements(By.xpath("//input"));
        Boolean checkbox1 = checkboxes.get(0).isSelected();
        System.out.printf("checkbox 1 checked: %s\n", checkbox1);
        checkboxes.get(0).click();
        checkbox1 = checkboxes.get(0).isSelected();
        System.out.printf("checkbox 1 checked: %s\n", checkbox1);

        Boolean checkbox2 = checkboxes.get(1).isSelected();
        System.out.printf("checkbox 2 checked: %s\n", checkbox2);
        checkboxes.get(1).click();
        checkbox2 = checkboxes.get(1).isSelected();
        System.out.printf("checkbox 2 checked: %s\n", checkbox2);

    }

}
