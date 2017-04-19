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

    public static String getBanner() {
        return System.getProperty("banner");
    }

    public static String getProductIdBasedOnBanner() {
        String productId = "";
        String banner = getBanner();
        if (banner.equals("saks")) {
            productId = "0424101393876";
        } else if (banner.equals("lt")) {
            productId = "0500041181629";
        }
        return productId;
    }

    public static String getGwpProductId() {
        String productId = "0500002036515";
        return productId;
    }

    public static boolean isLordAndTaylor() {
        return getBanner().toLowerCase().equals("lt");
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

    public static String getArtifactsDirectory() {
        String jsonDirectory = System.getProperty("buildDirectory") + "/artifacts";
        return jsonDirectory;
    }

    public static boolean isRemoteSelenium() {
        return (System.getProperty("remote") == null);
    }
}
