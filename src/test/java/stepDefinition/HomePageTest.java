package stepDefinition;

import config.ConfigFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HomePageFactory;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class HomePageTest {

    WebDriver driver;
    HomePageFactory homePage;
    ConfigFactory ConfigFileReader;



    // This runs before each test
    @Before()
    public void setup() {
        ConfigFileReader = new ConfigFactory();
        driver = driverUtil.driverFactory.open("chrome");
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS) ;

    }

    //Smoke test - verify that the home page loads properly
    @Given("The user is on the home page")
    public void user_home_page() {
        System.out.println("Opening URL: " + ConfigFileReader.getApplicationUrl());
        driver.get(ConfigFileReader.getApplicationUrl()) ;
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        homePage = new HomePageFactory(driver);
        homePage.clickOnAcceptCookiesInPopup();

    }

    @Then("The Clark Logo should be displayed")
    public void verify_page_logo () {
        Assert.assertTrue(homePage.isLogoDisplayed());
        Assert.assertTrue(homePage.isBedarfTextDisplayed());
    }

    @Then("The side profile icon should be displayed")
    public void verify_profile_icon(){
        Assert.assertTrue(homePage.isProfileIconDisplayed());
    }

    @When("The user clicks on 'Bedarf' in view")
    public void click_on_bedarf_text(){
        Assert.assertEquals(homePage.getBedarfTextHrefAttribute(), "https://staging.clark.de/de/app/recommendations");
        homePage.clickOnBedarfText();
    }

    @Then("The user should be navigated to the recommendations page successfully")
    public void user_on_bedarf_tab() throws InterruptedException {
        Thread.sleep(2000);
        String theUrl = driver.getCurrentUrl();
        Assert.assertEquals(theUrl, "https://staging.clark.de/de/app/recommendations?tab=no1-recommendation#");
    }
















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








