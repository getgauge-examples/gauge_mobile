package driver;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static SelendroidLauncher selendroidServer = null;

    public static void stopServer(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }
    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() throws Exception {
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }

        SelendroidConfiguration config = new SelendroidConfiguration();
        config.addSupportedApp("src/main/resources/selendroid-test-app-0.10.0.apk");
        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();

        SelendroidCapabilities caps =
                new SelendroidCapabilities("io.selendroid.testapp:0.10.0");

        return new SelendroidDriver(caps);
    }

}
