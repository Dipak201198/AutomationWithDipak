package utils.webdrivers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.logger.LogsManager;

class ChromeBrowser extends DriverManager {

    static LogsManager logManager = new LogsManager(ChromeBrowser.class.getName());

    @Override
    protected WebDriver initializeDriver() {

        WebDriver driver = null;

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions());
        } catch (Exception e) {
            logManager.logException(e, false, true);
        }

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // added below code to set default download path
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "test-output"
                + File.separator + "Downloaded Report");
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.merge(desiredCapabilities);

        return options;
    }
}
