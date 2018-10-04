import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginObjectRepo {

    static WebDriver driver;
    static WebDriverWait wait;


    //Declaring instance variables

    @FindBy(linkText = "Log In")
    WebElement loginBtn;

    @FindBy(id = "inputName")
    WebElement emailId;

    @FindBy(id = "pwd1")
    WebElement pwd;

    @FindBy(xpath = "//button[contains(text(),'LOGIN')]")
    WebElement submitBtn;


    //constructor to instantiate the instance variables using Page Factory
    public LoginObjectRepo(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //clicking on login button
    public void clkLoginBtn() {
        //initializing explicit wait

        loginBtn.click();

    }

    //providing email id
    public void setEmailId(String email) {

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(emailId)).sendKeys(email);

     //   emailId.sendKeys(email);

    }

    //providing password
    public void setPwd(String password) {

        pwd.sendKeys(password);

    }

    //clicking on submit button
    public void clickSubmit() {

        submitBtn.click();
    }

}
