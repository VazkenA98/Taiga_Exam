package base;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static config.DriverSetup.getDriver;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        getDriver().manage().window().maximize();
        getDriver().manage().addCookie(new Cookie("cookieConsent", "1"));
        getDriver().navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().navigate().refresh();
        System.out.println("Test ends! ");
        getDriver().quit();

    }
}
