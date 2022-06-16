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

    @FindBy(xpath = "//*[@id=\"ember95\"]")
    WebElement startNowBtn;


    public RecommendationPageFactory(WebDriver driver) {
        this.driver = driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }


    public boolean isStartNowBtnDisplayed() {
        try {
            return startNowBtn.isDisplayed();
        } catch (Exception e) {
            System.out.print("Start now button cannot be located \n" + e.getMessage());

            return false;
        }
    }



}
