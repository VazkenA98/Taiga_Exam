package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.DriverSetup.getDriver;

public class WaitHelper {


    public WaitHelper(){

    }

    public static WebElement waitUntilElementIsClickable(WebElement element){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementIsClickable(By location){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(location));
    }

    public static WebElement waitUntilElementIsVisible(By location){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(location));
    }

    public static WebElement waitUntilElementIsVisible(WebElement element){
        return new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }
}
