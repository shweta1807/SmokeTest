package utils;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import static utils.Config.getScreenshotDirectory;

public class ScreenShotRule extends TestWatcher {
    private WebDriver browser;

    public ScreenShotRule(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;

        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(getScreenshotDirectory() + "/" +"User_Session____"+ browser.manage().getCookieNamed("JSESSIONID").getValue()+"____"+"SESSION_ID____"+((RemoteWebDriver)browser).getSessionId().toString()+"____"+"error_" + description.getMethodName() + ".png");
        System.out.println("Screenshot Rule: "+browser.manage().getCookieNamed("JSESSIONID").getValue());
        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    @Override
    protected void finished(Description description) {
        browser.close();
    }
}