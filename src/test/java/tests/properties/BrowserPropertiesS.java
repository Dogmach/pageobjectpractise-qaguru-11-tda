package tests.properties;

public class BrowserPropertiesS {
    public static String remoteUser = System.getProperty("user", "user1");
    public static String remotePassword = System.getProperty("password", "1234");
    public static String remoteBrowser = System.getProperty("remoteBrowser", "selenoid.autotests.cloud/wd/hub");
    public static String browserSize = System.getProperty("browser_size", "1920x1520");
    public static String browser = System.getProperty("browser", "chrome");
    public static String browserVersion = System.getProperty("browserVersion", "100");



}
