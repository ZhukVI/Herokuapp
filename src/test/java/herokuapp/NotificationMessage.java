package herokuapp;

import framework.BaseTest;
import framework.Browser;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NotificationMessage extends BaseTest {
    private static final String NAV_SUBMENU_ITEM = "//a[contains(text(), '%s')]";
    private static final String CLICK_HERE_LABEL = "//a[contains(text(), 'Click here')]";
    private static final String NOTIFICATION = "//div[@class = 'flash notice']";



    @Test
    void inputsTest() {
        Label dropdownPage = new Label(By.xpath(String.format(NAV_SUBMENU_ITEM, "Notification Messages")));
        dropdownPage.clickAndWait();
        WebDriver driver1 = Browser.getDriver();

        Label label = new Label(By.xpath(CLICK_HERE_LABEL));

        String text = "Action successful";
        for (int i = 0; i < 6; i++){
            label.click();
            String b = driver1.findElement(By.xpath(NOTIFICATION)).getText();
            b = b.trim();
            if (b.contains(text)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
