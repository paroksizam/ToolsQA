package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {

    public WebDriver driver;
    WebElement yesButton;
    WebElement impressiveButton;
    WebElement noButton;
    WebElement message;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getYesButton() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(2) > label"));
    }

    public WebElement getImpressiveButton() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div:nth-child(3) > label"));
    }

    public WebElement getNoButton() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > div.custom-control.disabled.custom-radio.custom-control-inline > label"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("text-success"));
    }

    //-------------------------------------

    public void clickYes(){
        getYesButton().click();
    }

    public void clickImpressive(){
        getImpressiveButton().click();
    }

    public void clickNo(){
        getNoButton().click();
    }

    public String textFromMessage(){
        String text = getMessage().getText();
        return text;
    }
}
