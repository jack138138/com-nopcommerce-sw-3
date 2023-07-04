package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {

    public static WebDriver Mydriver;

    public void openBrowser(String MyUrl){
        //setup chrome
        Mydriver = new ChromeDriver();
        //open url
        Mydriver.get(MyUrl);

        //maximize window
        Mydriver.manage().window().maximize();

        //setup implicitly wait time

        Mydriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void closeBrowser(){
        //close browser
        Mydriver.quit();
    }



}