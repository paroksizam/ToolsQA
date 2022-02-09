package basepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.Elements;
import pages.Forms;
import pages.Homepage;
import pages.elements.*;
import pages.forms.PracticeForm;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homeURL;
    public Homepage homepage;
    public Elements elements;
    public TextBox textBox;
    public CheckBox checkBox;
    public RadioButton radioButton;
    public WebTables webTables;
    public Buttons buttons;
    public Links links;
    public BrokenLinksImages brokenLinksImages;
    public Forms forms;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\Marija\\IdeaProjects\\SeleniumFinalProject\\DemoQA.xlsx");
        homeURL = excelReader.getStringData("URL", 0, 1);
        homepage = new Homepage(driver);
        elements = new Elements(driver);
        textBox = new TextBox(driver);
        checkBox = new CheckBox(driver);
        radioButton = new RadioButton(driver);
        webTables = new WebTables(driver);
        buttons = new Buttons(driver);
        links = new Links(driver);
        brokenLinksImages = new BrokenLinksImages(driver);
        forms = new Forms(driver);
    }

    public void waitClick(WebElement e){
        wdwait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitVisibility(WebElement e){
        wdwait.until(ExpectedConditions.visibilityOf(e));
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();
    }
}
