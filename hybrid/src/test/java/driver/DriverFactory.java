package driver;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static void stopServer(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() throws Exception {
        SelendroidDriver driver = new SelendroidDriver(new SelendroidCapabilities("io.selendroid.directory:0.0.1"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }

}
