import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class UpdatePicture {

    static WebDriver driver;
    static WebDriverWait wait;

    //Declaring instance variables

    @FindBy(id = "personal_details")
    WebElement editBtn;

    @FindBy(className = "icon-camera")
    WebElement iconCamera;

    @FindBy(xpath = "//span[@class='uploadtext']")
    WebElement fileBtn;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    //constructor to instantiate the instance variables using Page Factory
    public UpdatePicture(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //navigating to my profile
    public void editBtnClick() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();

    }

    public void iconCameraClick() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(iconCamera)).click();

    }

    public void fileBtnClick() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(fileBtn).click().build().perform();
    }

    public void picSelect() throws FindFailed, InterruptedException {

        Screen s = new Screen();

     //   Pattern Open = new Pattern("/Users/prashantmundepi/Documents/Selenium_projects/MavenProjects/UploadEdurekaPic/Images/Open.jpg");
      //  Pattern pic = new Pattern("/Users/prashantmundepi/Documents/Selenium_projects/MavenProjects/UploadEdurekaPic/Images/MyPic.jpg");
      //  Thread.sleep(3000);
     //   s.type(pic, null);
    //    s.doubleClick(pic);


     //   s.click(Open);

    }

    public void uploadPic() {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }





}
