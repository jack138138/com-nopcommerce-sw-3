package utility;

import browsertest.BaseTest;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    String MyUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(MyUrl);
    }


    public void clickOnElement(By by){
        Mydriver.findElement(by).click();
    }

    public String getTextFromElement(By by)

    {
        return Mydriver.findElement(by).getText();

    }

    public void sendTextToElement (By by, String text){
        Mydriver.findElement(by).sendKeys("");


    }
    public void selectByVisibleTextFromDropDown(By by, String text){
       // WebElement dropDown = Mydriver.findElement(by);
       // Select Myselect = new Select(dropDown);
       //Myselect.selectByVisibleText(text);

        new Select(Mydriver.findElement(by)).selectByVisibleText(text); // single line
    }

    public void selectByValueFromDropDown(By by, String Value){
        new Select(Mydriver.findElement(by)).selectByValue(Value); // single line

        //in detail
        WebElement dropDown = Mydriver.findElement(by);
        Select Myselect = new Select(dropDown);
        Myselect.selectByValue(Value);

    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(Mydriver);
        WebElement mouseHoover = Mydriver.findElement(by);
//      Thread.sleep(3000);
//      waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(Mydriver);
        WebElement mouseHover = Mydriver.findElement(by);
        actions.moveToElement(mouseHover).click().build().perform();
    }






}
