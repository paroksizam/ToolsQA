package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons {

    public WebDriver driver;
    WebElement doubleClick;
    WebElement rightClick;
    WebElement click;
    WebElement doubleClickMessage;
    WebElement rightClickMessage;
    WebElement clickMessage;


    public Buttons(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDoubleClick() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClick() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClick() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button"));
    }

    public WebElement getDoubleClickMessage() {
        return driver.findElement(By.id("doubleClickMessage"));
    }

    public WebElement getRightClickMessage() {
        return driver.findElement(By.id("rightClickMessage"));
    }

    public WebElement getClickMessage() {
        return driver.findElement(By.id("dynamicClickMessage"));
    }

    //------------------------------

    public void doubleClick(){
        Actions actions = new Actions(driver);
        actions.doubleClick(getDoubleClick()).perform();
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        actions.contextClick(getRightClick()).perform();
    }

    public void clickClick(){
        getClick().click();
    }

    public String doubleClickText(){
        String text = getDoubleClickMessage().getText();
        return text;
    }

    public String rightClickText(){
        String text = getRightClickMessage().getText();
        return text;
    }

    public String clickText(){
        String text =  getClickMessage().getText();
        return text;
    }
}
