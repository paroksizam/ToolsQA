package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {

    public WebDriver driver;
    WebElement fullName;
    WebElement email;
    WebElement currentAdd;
    WebElement permanentAdd;
    WebElement submitButton;
    WebElement outputBox;

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAdd() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAdd() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getOutputBox() {
        return driver.findElement(By.id("output"));
    }

    //------------------------------------

    public void insertFullName(String x){
        getFullName().clear();
        getFullName().sendKeys(x);
    }

    public void insertEmail(String x){
        getEmail().clear();
        getEmail().sendKeys(x);
    }

    public void insertCurrentAdd(String x){
        getCurrentAdd().clear();
        getCurrentAdd().sendKeys(x);
    }

    public void insertPermanentAdd(String x){
        getPermanentAdd().clear();
        getPermanentAdd().sendKeys(x);
    }

    public void clickSubmit(){
        getSubmitButton().click();
    }
}
