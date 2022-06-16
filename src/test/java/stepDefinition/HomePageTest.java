package stepDefinition;

import config.ConfigFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePageTest {

    WebDriver driver;
    ConfigFactory ConfigFileReader;



    // This runs before each test
    @Before()
    public void setup() {
        driver = driverUtil.driverFactory.open("chrome");
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS) ;
        ConfigFileReader = new ConfigFactory();
    }
}
