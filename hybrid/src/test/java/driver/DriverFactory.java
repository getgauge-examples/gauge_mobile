package driver;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.android.AndroidEmulator;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

//    public static void stopServer(WebDriver driver) {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public static WebDriver getDriver() throws Exception {
//        SelendroidDriver driver = new SelendroidDriver(new SelendroidCapabilities("io.selendroid.directory:0.0.1"));
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//        return driver;
//    }

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
        config.addSupportedApp("src/test/resources/employee-directory.apk");
        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();


        SelendroidCapabilities desiredCapabilities =
                new SelendroidCapabilities("io.selendroid.directory:0.0.1");

//        desiredCapabilities.setModel("Nexus 5");

        SelendroidDriver driver = new SelendroidDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }


}
