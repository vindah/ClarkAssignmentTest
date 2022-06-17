package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

    WebDriver driver;

    //Getting all the elements/selectors on the pages
    @FindBy(id = "ember6")
    WebElement clarkLogo;

    @FindBy(xpath = "//*[@id=\"ember4\"]/div/div/div/header/nav/ul[1]/li[2]/a")
    WebElement bedarfText;

    @FindBy(id= "ember7")
    WebElement profileIcon;

    @FindBy(xpath = "//*[@id=\"ember4\"]/div[2]/form/div[4]/button")
    WebElement acceptCookieBtn;


    public HomePageFactory(WebDriver driver) {
        this.driver = driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }


    //Methods below are for different actions on the home page

    //Check that Logo is displayed
    public boolean isLogoDisplayed() {
        try {
            return clarkLogo.isDisplayed();
        } catch (Exception e) {
            System.out.print("Logo cannot be located \n" + e.getMessage());
            return false;
        }
    }

    //Check that Bedarf text is visible
    public boolean isBedarfTextDisplayed() {
        try {
            return bedarfText.isDisplayed();
        } catch (Exception e) {
            System.out.print("Bedarf text cannot be located \n" + e.getMessage());

            return false;
        }
    }

    //Check that profile icon is visible
    public boolean isProfileIconDisplayed() {
        try {
            return profileIcon.isDisplayed();
        } catch (Exception e) {
            System.out.print("Profile icon cannot be located \n" + e.getMessage());

            return false;
        }
    }

    //Click on the Bedarf text
    public void clickOnBedarfText() {
        bedarfText.click();
    }


    //Click on the clark logo to return to home page
    public void clickOnClarkLogoText(){
        clarkLogo.click();
    }


    //Click on the Accept button in popup
    public void clickOnAcceptCookiesInPopup(){
        acceptCookieBtn.click();
    }


    public String getBedarfTextHrefAttribute () {
        return bedarfText.getAttribute("href");
    }

}




