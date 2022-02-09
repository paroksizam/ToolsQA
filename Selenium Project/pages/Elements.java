package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Elements {

    public WebDriver driver;
    List<WebElement> items;
    WebElement header;

    public Elements(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getItems() {
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }

    public WebElement getHeader() {
        return driver.findElement(By.className("main-header"));
    }

    //-----------------------------------

    public void clickItem(int x){
        getItems().get(x).click();
    }

    public String textHeader(){
        String text = getHeader().getText();
        return text;
    }
}
