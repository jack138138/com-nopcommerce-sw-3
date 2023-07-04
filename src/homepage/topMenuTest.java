package homepage;

import browsertest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

//create class "TopMenuTest
public class topMenuTest extends BaseTest {
    String MyUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(MyUrl);
    }


    //create method with name "selectMenu" it has one parameter name "menu" of type string
@Test
    public void verifyPageNavigation() {

        selectMenu("Computers");  // Replace with the desired menu name

       // Verify Page Navigation
        String expectedTitle = "Computers"; // replace with top menu name on page
         String actualTitle = Mydriver.getTitle();
         Assert.assertEquals("Not available in page",expectedTitle,actualTitle);
         }

        public void selectMenu (String menu) {


    Mydriver.findElement(By.xpath("//body/div[6]/div[2]")).click();

    }




        public void tearDown () {
            // Close the browser
            Mydriver.quit();
        }
    }
