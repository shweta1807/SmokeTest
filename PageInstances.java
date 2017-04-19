import org.fluentlenium.core.annotation.Page;
import org.junit.Rule;
import org.junit.rules.TestName;
import pages.*;
import utils.ScreenShotRule;
import utils.SeleniumConfig;

public class PageInstances extends SeleniumConfig {


    @Page
    protected HomePage homePage;

    @Page
    protected Resultpage resultPage;

    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(getDefaultDriver());

    @Rule
    public TestName testName = new TestName();
}
