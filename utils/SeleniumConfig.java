package utils;

import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.HttpURLConnection;
import java.net.URL;

public class SeleniumConfig extends FluentTest {

    public WebDriver driver = null;
    String browserType = System.getProperty("browser");

    public WebDriver createRemoteDriver() {
        URL server_URL = Config.getSeleniumServerUrl();

        try {
            if (browserType == null) {
                return new RemoteWebDriver(server_URL, DesiredCapabilities.firefox());
            }
            switch (browserType) {
                case "firefox":
                    return new RemoteWebDriver(server_URL, DesiredCapabilities.firefox());
                case "chrome":
                    return new RemoteWebDriver(server_URL, DesiredCapabilities.chrome());
                case "ie":
                    return new RemoteWebDriver(server_URL, DesiredCapabilities.internetExplorer());
                default:
                    return new RemoteWebDriver(server_URL, DesiredCapabilities.firefox());
            }

        } catch (Exception e) {
            if (isSeleniumServerRunning()) try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw new SeleniumServerUnavailableException("Selenium server is not running. Server Url - " + server_URL, e);
        }
    }

    class SeleniumServerUnavailableException extends RuntimeException {
        SeleniumServerUnavailableException(String message, Exception ex) {
            super(message, ex);
        }
    }

    public static boolean isSeleniumServerRunning() {
        String baseUrl = Config.getSeleniumServerUrl().toString();
        try {
            System.out.println("Checking selenium server status [" + baseUrl + "]");

            URL url = new URL(baseUrl + "/selenium-server/driver/?cmd=getLogMessages");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
                return true;
        } catch (Exception e) {
            System.err.println("Selenium server is not running: " + e.getMessage());
        }
        return false;
    }

    @Override
    public WebDriver getDefaultDriver() {
        if (driver == null) {
            driver = Config.isRemoteSelenium() ? new FirefoxDriver() : createRemoteDriver();
        }

        return driver;
    }

    @Override
    public String getDefaultBaseUrl() {
        return Config.getWebsite();
    }
}
