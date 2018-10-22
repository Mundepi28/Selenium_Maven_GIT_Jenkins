import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestScripts {

    static WebDriver driver;

    //before suit to launch the browser, providing synchronisation commands and navigate to the edureka
    @BeforeSuite
    public void launchEdureka() {

        //Launching chrome browser
        System.setProperty("webdriver.chrome.driver", ".//driver_executables/chromedriver");
        driver = new ChromeDriver();

        //pageLoadTimeout and  implicit wait
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        //Navigating to edureka
        driver.get("https://www.edureka.co");
//        driver.manage().window().maximize();
    }

    //test to perform login to the edureka account successfully
    @Test(priority = 0)
    public void logIn() {

        LoginObjectRepo lo = new LoginObjectRepo(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lo.clkLoginBtn();  //click on login button to provide login credentials
        lo.setEmailId("mundepi28@gmail.com");  //providing email id

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lo.setPwd("Newuser@123");              //providing password
        lo.clickSubmit();                        //submit the details

    }

    @Test(dependsOnMethods = {"logIn"})
    public void profileNavigateCheck() {

        HomePageObjectRepo ho = new HomePageObjectRepo(driver);

        ho.myProfile();
        ho.myProfileBtnClick();
    }

    @Test(dependsOnMethods = {"profileNavigateCheck"})
    public void UpdatePicCheck() throws FindFailed, InterruptedException {

        UpdatePicture up = new UpdatePicture(driver);

        up.editBtnClick();
        up.iconCameraClick();
        up.fileBtnClick();
        up.picSelect();
        up.uploadPic();
    }

    @AfterSuite                      //   closing the browser
    public void closeBrowser() {

        driver.close();
    }



}
