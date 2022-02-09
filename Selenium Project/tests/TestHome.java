package tests;

import basepage.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHome extends BasePage {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to(homeURL);
        driver.manage().window().maximize();
    }

    @Test
    public void userIsOnElementsPage(){
        scroll(homepage.getCategories().get(0));
        homepage.clickCategory(0);

        String expectedURL = excelReader.getStringData("URL", 1, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        String expectedText = excelReader.getStringData("Header", 0,0);
        String actualText = elements.textHeader();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void userIsOnFormsPage(){
        scroll(homepage.getCategories().get(1));
        homepage.clickCategory(1);

        String expectedURL = excelReader.getStringData("URL", 3, 1);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        String expectedText = excelReader.getStringData("Header", 1,0);
        String actualText = elements.textHeader();
        Assert.assertEquals(actualText, expectedText);
    }
}
