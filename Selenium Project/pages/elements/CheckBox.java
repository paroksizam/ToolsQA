package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox {

    public WebDriver driver;
    WebElement expandAllButton;
    WebElement collapseAllButton;
    WebElement collapseArray;
    WebElement checkboxParent;
    WebElement checkboxParentChecked;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getExpandAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-expand-all"));
    }

    public WebElement getCollapseAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-collapse-all"));
    }

    public WebElement getCollapseArray() {
        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
    }

    public WebElement getCheckboxParent() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
    }

    public WebElement getCheckboxParentChecked() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-check"));
    }

    //--------------------------------

    public void clickCheckboxParent(){
        getCheckboxParent().click();
    }
}
