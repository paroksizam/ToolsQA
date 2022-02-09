package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage {

    public WebDriver driver;
    List<WebElement> categories;
    WebElement logo;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCategories() {
        return driver.findElements(By.className("card-body"));
    }

    public WebElement getLogo() {
        return driver.findElement(By.cssSelector("#app > header > a > img"));
    }

    //---------------------------------------------

    public void clickCategory(int x){
        getCategories().get(x).click();
    }
}
