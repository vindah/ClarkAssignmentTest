package stepDefinition;

import config.ConfigFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HomePageFactory;
import pages.RecommendationPageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    ConfigFactory ConfigFileReader;

    // This runs before each test
    @Before()
    public void setup() {
        ConfigFileReader = new ConfigFactory();
        driver = driverUtil.driverFactory.open("chrome");
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS) ;

    }


    //This runs after each test
    @After()
    public void takeScreenshots_and_quitDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        //eyes.abortIfNotClosed();
        driver.quit();
    }


}
