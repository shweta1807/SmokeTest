package utils;

import java.net.URL;

public class Config {

    public static URL getSeleniumServerUrl() {
        String SERVER_URL = System.getProperty("selenium_server");

        URL server_URL = null;

        try {
            server_URL = new URL(SERVER_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server_URL;
    }

    public static String getWebsite() {
        String url = System.getProperty("env");

        if (url == null) {
            try {
                throw new Exception("Website URL can not be empty, please provide website parameter (-Dwebsite=<URL>)");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return "https://" + url;
        }
    }

    public static String getScreenshotDirectory() {
        String screenShotDirectory = System.getProperty("buildDirectory") + "/reports/screenshots";
        return screenShotDirectory;
    }


    public static boolean isRemoteSelenium() {
        return (System.getProperty("remote") == null);
    }
}
