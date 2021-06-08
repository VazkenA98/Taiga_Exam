import base.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.Discover;
import pageObject.ProjectPage;

import static config.DriverSetup.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class DiscoverTest extends BaseTest {


    @Test
    public void discoverPage(){
        Discover discover =  new Discover().open();
        assertEquals(discover.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Discover Page]");
        assertTrue(discover.isTitleDisplayed(),"Title was not displayed");

        ProjectPage projectPage = discover.clickOnPenpot().open();
        assertEquals(projectPage.getUrl(),getDriver().getCurrentUrl(),"Did not navigate to [Project Page]");

    }
}
