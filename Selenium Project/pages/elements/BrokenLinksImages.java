package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksImages {

    public WebDriver driver;
    WebElement validImage;
    WebElement brokenImage;
    WebElement validLink;
    WebElement brokenLink;

    public BrokenLinksImages(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidImage() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > img:nth-child(2)"));
    }

    public WebElement getBrokenImage() {
        return driver.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(1) > img:nth-child(6)"));
    }

    public WebElement getValidLink() {
        return driver.findElement(By.linkText("Click Here for Valid Link"));
    }

    public WebElement getBrokenLink() {
        return driver.findElement(By.linkText("Click Here for Broken Link"));
    }

    //------------------------------------------

    public void clickValidLink(){
        getValidLink().click();
    }

    public void clickBrokenLink(){
        getBrokenLink().click();
    }
}
