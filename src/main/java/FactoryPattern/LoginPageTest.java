package FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = DriverFactory.getDriver("chrome").createDriver();
        driver.get("https://panos994.github.io/panosfoteinopoulos_/");
    }

    @Test
    public void loginTest(){
        Assert.assertEquals(driver.getTitle(), "Portfolio site");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
