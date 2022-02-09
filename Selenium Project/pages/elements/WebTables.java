package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTables {

    public WebDriver driver;
    WebElement addButton;
    WebElement searchTextbox;
    List<WebElement> editButton;
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    WebElement age;
    WebElement salary;
    WebElement department;
    WebElement submitButton;
    List<WebElement> rows;

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getSearchTextbox() {
        return driver.findElement(By.id("searchBox"));
    }

    public List<WebElement> getEditButton() {
        return driver.findElements(By.className("mr-2"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getAge() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSalary() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getDepartment() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public List<WebElement> getRows() {
        return driver.findElements(By.className("rt-tr-group"));
    }

    //------------------------------------------------

    public void clickEdit(int x){
        getEditButton().get(x).click();
    }
    public void clickAdd(){
        getAddButton().click();
    }

    public void insertFirstName(String name){
        getFirstName().clear();
        getFirstName().sendKeys(name);
    }

    public void insertLastName(String lastname){
        getLastName().clear();
        getLastName().sendKeys(lastname);
    }

    public void insertEmail(String mail){
        getEmail().clear();
        getEmail().sendKeys(mail);
    }

    public void insertAge(String  age){
        getAge().clear();
        getAge().sendKeys(age);
    }

    public void insertSalary(String salary){
        getSalary().clear();
        getSalary().sendKeys(salary);
    }

    public void insertDepartment(String dep){
        getDepartment().clear();
        getDepartment().sendKeys(dep);
    }

    public void clickSubmit(){
        getSubmitButton().click();
    }

    public boolean changedTextFromTable(int index, String change){
        boolean goodChange = false;
        String text = getRows().get(index).getText();
        if(text.contains(change)){
            goodChange = true;
        }
        return goodChange;
    }

//    public boolean newRow(WebElement row){
//        boolean newRow = false;
//        String newText = row.getText();
//        if(newText != null){
//            newRow = true;
//        }
//        return newRow;
//    }
}
