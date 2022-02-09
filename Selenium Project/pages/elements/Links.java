package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Links {

    public WebDriver driver;
    WebElement linkHome;
    WebElement linkHomeDynamic;

    public Links(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLinkHome() {
        return driver.findElement(By.id("simpleLink"));
    }

    public WebElement getLinkHomeDynamic() {
        return driver.findElement(By.id("dynamicLink"));
    }

    //-----------------------------------

    public void clickHome(){
        getLinkHome().click();
    }

    public void clickDynamicHome(){
        getLinkHomeDynamic().click();
    }
}
