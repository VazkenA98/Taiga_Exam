package pageObject;

import helper.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static config.DriverSetup.getDriver;

public class Discover extends BasePage<Discover>
{

    @FindBy(css = "[class='discover-header-inner'] h1")
    private WebElement mainTitle;

    @FindBy(css = "[class='featured-project']")
    private List<WebElement> featureItems;

    @FindBy(css = "[class*='project-card-inner']")
    private List<WebElement> cardHyperText;

    private static String url = "/discover";
    private String queryUrl;

    public Discover(){
        PageFactory.initElements(getDriver(), this);
    }

    public Discover(String queryUrl){
        this.queryUrl = queryUrl;
        PageFactory.initElements(getDriver(), this);
    }

    public Discover open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        String query = queryUrl == null ? url : url + "?" + queryUrl;
        return BASE_URL.concat(query);
    }

    public boolean isTitleDisplayed(){
        WaitHelper.waitUntilElementIsVisible(mainTitle);
        return isDisplayed(mainTitle);
    }

    public int getFeatureSize(){
        return cardHyperText.size();
    }

    public ProjectPage clickOnPenpot(){
        WaitHelper.waitUntilElementIsVisible(cardHyperText.get(0));
        clickAndSwitchToNextTab(cardHyperText.get(0));
        return new ProjectPage("/uxbox/timeline");
    }
}
