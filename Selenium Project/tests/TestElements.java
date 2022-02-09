package tests;

import basepage.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestElements extends BasePage {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to(homeURL);
        driver.manage().window().maximize();
        scroll(homepage.getCategories().get(0));
        homepage.clickCategory(0);
    }

    public void choseItem(int item){
        scroll(elements.getItems().get(item));
        waitClick(elements.getItems().get(item));
        elements.clickItem(item);
    }

    @Test
    public void userCanInsertCredentialsSuccessfully(){
        choseItem(0);
        textBox.insertFullName(excelReader.getStringData("Elements", 2, 0));
        textBox.insertEmail(excelReader.getStringData("Elements", 2, 1));
        textBox.insertCurrentAdd(excelReader.getStringData("Elements", 2, 2));
        textBox.insertPermanentAdd(excelReader.getStringData("Elements", 2, 3));
        scroll(textBox.getSubmitButton());
        textBox.clickSubmit();

        Assert.assertTrue(textBox.getOutputBox().isDisplayed());
    }

    @Test
    public void clickOnHomeMakeAllCheckboxesChecked() {
        choseItem(1);
        waitClick(checkBox.getCheckboxParent());
        checkBox.clickCheckboxParent();

        Assert.assertTrue(checkBox.getCheckboxParentChecked().isDisplayed());
    }

    @Test
    public void userCanClickOnYesButton() {
        choseItem(2);
        waitClick(radioButton.getYesButton());
        radioButton.clickYes();

        Assert.assertTrue(radioButton.getMessage().isDisplayed());

        String expectedMessage = "Yes";
        String actualMessage = radioButton.textFromMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void userCanClickOnImpressiveButton() {
        choseItem(2);
        waitClick(radioButton.getImpressiveButton());
        radioButton.clickImpressive();

        waitVisibility(radioButton.getMessage());
        Assert.assertTrue(radioButton.getMessage().isDisplayed());

        String expectedMessage = "Impressive";
        String actualMessage = radioButton.textFromMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void userCanClickOnNoButton() {
        choseItem(2);
        waitClick(radioButton.getNoButton());
        radioButton.getNoButton();

        Assert.assertTrue(radioButton.getMessage().isDisplayed());

        String expectedMessage = "No";
        String actualMessage = radioButton.textFromMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void editAge() {
        choseItem(3);
        waitClick(webTables.getEditButton().get(0));
        webTables.clickEdit(0);
        webTables.insertAge(String.valueOf(excelReader.getIntegerData("Elements", 6, 3)));
        webTables.clickSubmit();

        String expectedChange = String.valueOf(excelReader.getIntegerData("Elements", 6, 3));

        Assert.assertTrue(webTables.changedTextFromTable(0, expectedChange));
    }

    @Test
    public void insertRow() {
        choseItem(3);
        waitClick(webTables.getAddButton());
        webTables.clickAdd();
        webTables.insertFirstName(excelReader.getStringData("Elements", 6, 0));
        webTables.insertLastName(excelReader.getStringData("Elements", 6, 1));
        webTables.insertEmail(excelReader.getStringData("Elements", 6, 2));
        webTables.insertAge(String.valueOf(excelReader.getIntegerData("Elements", 6, 3)));
        webTables.insertSalary(String.valueOf(excelReader.getIntegerData("Elements", 6, 4)));
        webTables.insertDepartment(excelReader.getStringData("Elements", 6, 5));
        webTables.clickSubmit();
    }

    @Test
    public void doubleClickIsClickable() {
        choseItem(4);
        waitClick(buttons.getDoubleClick());
        buttons.doubleClick();

        Assert.assertTrue(buttons.getDoubleClickMessage().isDisplayed());

        String expectedMessage = "You have done a double click";
        Assert.assertEquals(buttons.doubleClickText(), expectedMessage);
    }

    @Test
    public void rightClickIsClickable() {
        choseItem(4);
        waitClick(buttons.getRightClick());
        buttons.rightClick();

        Assert.assertTrue(buttons.getRightClickMessage().isDisplayed());

        String expectedMessage = "You have done a right click";
        Assert.assertEquals(buttons.rightClickText(), expectedMessage);
    }

    @Test
    public void clickIsClickable() {
        choseItem(4);
        waitClick(buttons.getClick());
        buttons.clickClick();

        Assert.assertTrue(buttons.getClickMessage().isDisplayed());

        String expectedMessage = "You have done a dynamic click";
        Assert.assertEquals(buttons.clickText(), expectedMessage);
    }

    @Test
    public void linkHomeOpensInNewTab() {
        choseItem(5);
        links.clickHome();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String expectedURL = excelReader.getStringData("URL", 0, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(homepage.getLogo().isDisplayed());
    }

    @Test
    public void linkHomeDynamicOpensInNewTab() {
        choseItem(5);
        links.clickDynamicHome();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String expectedURL = excelReader.getStringData("URL", 0, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(homepage.getLogo().isDisplayed());
    }

    @Test
    public void validImageIsVisible() {
        choseItem(6);

        Assert.assertTrue(brokenLinksImages.getValidImage().isDisplayed());
    }

    @Test
    public void brokenImageIsVisible() {
        choseItem(6);

        Assert.assertTrue(brokenLinksImages.getBrokenImage().isDisplayed());
    }

    @Test
    public void validLinkIsClickable() {
        choseItem(6);

        scroll(brokenLinksImages.getValidLink());
        brokenLinksImages.clickValidLink();

        String expectedURL = excelReader.getStringData("URL", 0, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(homepage.getLogo().isDisplayed());
    }

    @Test
    public void brokenLinkIsClickable() {
        choseItem(6);

        scroll(brokenLinksImages.getBrokenLink());
        brokenLinksImages.clickBrokenLink();

        String expectedURL = excelReader.getStringData("URL", 2, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
}
