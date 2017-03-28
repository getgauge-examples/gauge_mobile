package driver;

import com.thoughtworks.gauge.*;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    @BeforeSuite
    public void initializeDriver() throws Exception {
        webDriver = DriverFactory.getDriver();
    }

    @AfterSuite
    public void closeDriver(){
        DriverFactory.stopServer(webDriver);
    }

}
