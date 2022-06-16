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

public class HomePageTest extends BaseTest{

    HomePageFactory homePage;
    RecommendationPageFactory recommendationPage;




    //Smoke test - verify that the home page loads properly
    @Given("The user is on the home page")
    public void user_home_page() {
        System.out.println("Opening URL: " + ConfigFileReader.getApplicationUrl());
        driver.get(ConfigFileReader.getApplicationUrl()) ;
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        homePage = new HomePageFactory(driver);
        recommendationPage = new RecommendationPageFactory(driver);
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
    public void user_on_bedarf_tab() {
        Assert.assertTrue(recommendationPage.isStartNowBtnDisplayed());
    }

















}








