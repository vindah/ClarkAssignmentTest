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
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePageFactory;
import io.cucumber.java.Scenario;
import pages.RecommendationPageFactory;

import java.util.concurrent.TimeUnit;

public class HomePageSteps {

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
    @Given("The user is on the home page")
    public void user_home_page() {
        System.out.println("Opening URL: " + ConfigFileReader.getApplicationUrl("url"));
        driver.get(ConfigFileReader.getApplicationUrl("url")) ;
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        homePage = new HomePageFactory(driver);
        recommendationPage = new RecommendationPageFactory(driver);
        homePage.clickOnAcceptCookiesInPopup();
        //homePage.clickOnClarkLogoText();
    }

    @Then("The Clark Logo should be displayed")
    public void clark_page_logo_should_be_displayed () {
        Assert.assertTrue(homePage.isLogoDisplayed());
        Assert.assertTrue(homePage.isBedarfTextDisplayed());
    }

    @Then("The side profile icon should be displayed")
    public void side_profile_icon_should_be_displayed(){
        Assert.assertTrue(homePage.isProfileIconDisplayed());
    }

    @When("The user clicks on 'Bedarf' in view")
    public void click_on_bedarf_text(){
        Assert.assertEquals(homePage.getBedarfTextHrefAttribute(), "https://staging.clark.de/de/app/recommendations");
        homePage.clickOnBedarfText();
    }

    @Then("The user should be navigated to the recommendations page successfully")
    public void user_on_bedarf_tab() {
        Assert.assertTrue(recommendationPage.isStartNowBtnDisplayed());
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








