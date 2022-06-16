package driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
    //This method returns a WebDriver object
    public static WebDriver open(String browserType) {
        if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("safari")) {

            /* Go to Safari -> Preferences-> Advanced
             * Tick mark the Checkbox with the label – Show Develop menu in menu bar
             * Go to the Develop menu and click on the Allow Remote Automation option to enable it. */
            return new SafariDriver();
        }
        else  {
            System.out.println("Current OS => " + System.getProperty("os.name"));

            if(System.getProperty("os.name").contains("Linux")) {
                WebDriverManager.chromedriver().setup();
            }

            if(System.getProperty("os.name").contains("Mac"))
                WebDriverManager.chromedriver().setup();

            if(System.getProperty("os.name").contains("Windows"))
                WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("--headless");
            return new ChromeDriver(options);
        }
    }
}
