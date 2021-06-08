package pageObject;

import helper.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.*;
import java.util.ArrayList;
import java.util.List;


import static config.DriverSetup.getDriver;

public abstract class BasePage<T> {
    protected WebDriver driver;
    public static final String BASE_URL="https://tree.taiga.io";
    public static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    protected void open(String url) {
        LOGGER.info("Opening Url " + getDriver().getCurrentUrl());
        driver.get(url);
    }

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        LOGGER.info("Initialising to " + getDriver().getCurrentUrl());
        return (T) this;
    }

    protected WebElement find(By location) {
        WaitHelper.waitUntilElementIsVisible(location);
        return driver.findElement(location);
    }

    protected void click(By location) {
        System.out.println("Clicking on element -> " + location.toString());
        click(find(location));
    }

    protected void click(WebElement element) {
        clickActions(element);
        element.click();
    }

    protected void clickActions(WebElement element) {
        WaitHelper.waitUntilElementIsVisible(element);
        WaitHelper.waitUntilElementIsClickable(element);
        new Actions(getDriver()).moveToElement(element).click().build().perform();
    }

    protected void clickAndSwitchToNextTab(WebElement element) {
        WaitHelper.waitUntilElementIsClickable(element);
        System.out.println("Clicking on element -> " + element.toString());
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    protected void clickByJS(By location) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", find(location));
    }
    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
