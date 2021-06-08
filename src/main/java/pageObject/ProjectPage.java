package pageObject;

import org.openqa.selenium.support.PageFactory;

import static config.DriverSetup.getDriver;

public class ProjectPage extends BasePage<ProjectPage>{

    private static String url = "/project";
    private String queryUrl;

    public ProjectPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public ProjectPage(String queryUrl){
        this.queryUrl = queryUrl;
        PageFactory.initElements(getDriver(), this);
    }

    public ProjectPage open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        String query = queryUrl == null ? url : url  + queryUrl;
        return BASE_URL.concat(query);
    }
}
