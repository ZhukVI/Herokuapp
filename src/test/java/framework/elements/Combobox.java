package framework.elements;

import org.openqa.selenium.By;

public class Combobox extends BaseElement {

    public Combobox(By by) {
        super(by);
    }
    @Override
    protected String getElementType() {
        return "Combobox: ";
    }
}
