package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forms {

    public WebDriver driver;
    WebElement practiceForm;
    WebElement header;

    public Forms(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPracticeForm() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li"));
    }

    public WebElement getHeader() {
        return driver.findElement(By.className("main-header"));
    }

    //-------------------------------------------

    public void clickPracticeForm(){
        getPracticeForm().click();
    }

    public String textHeader(){
        String text = getHeader().getText();
        return text;
    }
}
