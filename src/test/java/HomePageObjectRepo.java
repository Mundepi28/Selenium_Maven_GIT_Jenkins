import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjectRepo {

    static WebDriver driver;
    static WebDriverWait wait;

    //Declaring instance variables

    @FindBy(xpath = "(//span[@class='webinar-profile-name'])[1]")
    WebElement profile;

    @FindBy(xpath = "(//a[contains(text(),'My Profile')])[1]")
    WebElement profileBtn;

    //constructor to instantiate the instance variables using Page Factory
    public HomePageObjectRepo(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //navigating to my profile
    public void myProfile() {
        profile.click();

    }

    public void myProfileBtnClick() {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(profileBtn)).click();

    }




}
