package framework.elements;

import org.openqa.selenium.By;

public class Dropdown extends BaseElement{

    public Dropdown(By by) {
        super(by);
    }
    @Override
    protected String getElementType() {
        return "Dropdown: ";
    }
}
