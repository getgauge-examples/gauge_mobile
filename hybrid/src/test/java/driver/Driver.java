package driver;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;

    @BeforeSpec
    public void initializeDriver() throws Exception {
        webDriver = DriverFactory.getDriver();
    }

    @AfterSpec
    public void closeDriver(){
        DriverFactory.stopServer(webDriver);
    }

}
