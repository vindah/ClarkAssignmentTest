package stepDefinition;

import config.ConfigFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePageFactory;
import pages.RecommendationPageFactory;

import java.util.concurrent.TimeUnit;

public class RecommendationPageSteps {


    WebDriver driver;
    ConfigFactory ConfigFileReader;
    HomePageFactory homePage;
    RecommendationPageFactory recommendationPage;



    // This runs before test
    @Before()
    public void setup() throws InterruptedException {
        ConfigFileReader = new ConfigFactory();
        driver = driverUtil.driverFactory.open("chrome");
        driver.manage().deleteAllCookies(); //delete all cookies
        Thread.sleep(3000); //wait 7 seconds to clear cookies.
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS) ;

    }


    //Smoke test - verify that the home page loads properly
    @Given("The user is on the recommendations page")
    public void user_home_page() {
        System.out.println("Opening URL: " + ConfigFileReader.getApplicationUrl("url2"));
        driver.get(ConfigFileReader.getApplicationUrl("url2")) ;
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        //homePage = new HomePageFactory(driver);
        recommendationPage = new RecommendationPageFactory(driver);

    }

    @When("The user clicks on the 'Start now' button")
    public void click_on_start_now_button(){
        recommendationPage.clickOnStartNow();
    }

    @Then("The recommendations form should be displayed")
    public void recommendations_page_is_displayed(){
        Assert.assertTrue(recommendationPage.isDateFieldDisplayed());
    }

    @When("The user clicks on the date field and enters a date")
    public void click_on_the_date_field_and_enter_date(){
        recommendationPage.clickOnDateFieldAndTypeDate("19.02.1998");
    }














    //This runs after test
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
