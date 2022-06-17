package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendationPageFactory {

    WebDriver driver;

    //Getting all the elements/selectors on the pages
    @FindBy(className = "_title-container_ijqj2q")
    WebElement titleSlider;

    @FindBy(linkText = "Jetzt starten")
    WebElement startNowBtn;

    @FindBy(className = "datepicker picker")
    WebElement dateIcon;

    @FindBy(className = "datepicker-container")
    WebElement datePicker;

    @FindBy(className = "ember-text-field")
    WebElement dateField;


    public RecommendationPageFactory(WebDriver driver) {
        this.driver = driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }


    //check that start not btn is displayed
    public boolean isStartNowBtnDisplayed() {
        try {
            return startNowBtn.isDisplayed();
        } catch (Exception e) {
            System.out.print("Start now button cannot be located \n" + e.getMessage());

            return false;
        }
    }

    //check that start not btn is displayed
    public boolean isDateFieldDisplayed() {
        try {
            return dateField.isDisplayed();
        } catch (Exception e) {
            System.out.print("Date field cannot be located \n" + e.getMessage());

            return false;
        }
    }


    //Click on the date icon
    public void clickOnDateIcon(){
        dateIcon.click();
    }

    //Click on date field
    public void clickOnDateFieldAndTypeDate(String date){
        dateField.sendKeys(date);
    }

    //Click on start now button
    public void clickOnStartNow(){
        startNowBtn.click();
    }







}
