package eloctronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utility.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));

        //Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Wrong Message Shown", expectedText, actualText);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{

        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics ']"));

        //Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //Verify the text “Cell phones”
        String expectedPhoneText = "Cell phones";
        String actualPhoneText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Error Message Shown", expectedPhoneText, actualPhoneText);

        // Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //Click on product name “Nokia Lumia 1020” link

        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(1000);

        //Verify the text “Nokia Lumia 1020”
        String expectedNokiaLumia = "Nokia Lumia 1020";
        String actualNokiaLumia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Erron in Nokia lumia", expectedNokiaLumia, actualNokiaLumia);


        // Verify the price “$349.00”
        String expectedPrice = "349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Error in Price", expectedPrice, actualPrice);

        // Change quantity to 2
        sendTextToElement(By.id("product_enteredQuantity_20"), Keys.BACK_SPACE + "2");

        //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar After that
        String expectedFrameMSG = "The product has been added to your shopping cart";
        String actualFrameMSG = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Error in FRAME MSG", expectedFrameMSG, actualFrameMSG);


       //close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(1000);

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);

        //Verify the message "Shopping cart"
        String expectedCart = "Shopping cart";
        String actualCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Error In Cart", expectedCart,actualCart);



        //Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = getTextFromElement(By.xpath("span[contains(text(),'(2)')]"));

        //Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
        Assert.assertEquals("Error in Total", expectedCart, actualCart);


        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //Verify the Text “Welcome, Please Sign In!”
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Error",expectedWelcome,actualWelcome);

        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        // Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));

        // Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Jack");
        sendTextToElement(By.id("LastName"),"Sparrow");
        sendTextToElement(By.id("Email"),"JackSparrow@gmail.com");
        sendTextToElement(By.id("Password"),"Prime@123");
        sendTextToElement(By.id("ConfirmPassword"),"Prime@123");
        Thread.sleep(1000);

        //Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //Verify the message “Your registration completed”
        String expectedRegistration = "Your registration completed";
        String actualRegistration = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Error In Registration", expectedRegistration, actualRegistration);
        Thread.sleep(1000);

        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));


        //Verify the text “Shopping cart”
        String expectedCart1 = "Shopping cart";
        String actualCart1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Error in CART", expectedCart1,actualCart1);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(1000);

        //Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"123 High Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"EC157YN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"1234567");
        Thread.sleep(1000);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);

        //Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        Thread.sleep(1000);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);
        //Select “Visa” From Select credit card dropdown
      selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        Thread.sleep(1000);
        //Fill all the details
        sendTextToElement(By.id("CardholderName"), "Jack Sparrow");
        Thread.sleep(1000);
        sendTextToElement(By.id("CardNumber"), "5865 5858 5858 5858");
        Thread.sleep(1000);
       selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "11");
      selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        Thread.sleep(1000);
        sendTextToElement(By.id("CardCode"), "113");
        Thread.sleep(1000);


        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);


        // Verify “Payment Method” is “Credit Card”
        String expectedCard = "Credit Card";
        String actualCard = getTextFromElement(By.xpath("//span[contains(text(),'Payment Method:')]"));
        Assert.assertEquals("Error In Card",expectedCard, actualCard );



        //Verify “Shipping Method” is “2nd Day Air”
        String expectedShipping = "2nd Day Air";
        String actualShipping = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Error in page",expectedShipping,actualShipping);
        Thread.sleep(1000);


        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        String expectedThanks = "Thank You";
        String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));


        //Verify the message “Your order has been successfully processed!”
        String expectedproceed = "Your order has been successfully processed!";
        String actualProceed = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Error In Proceed", expectedproceed, actualProceed);

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expectedStore = "Welcome to our store";
        String actualStore = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Error in welcome", expectedStore, actualStore);

        //Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //Verify the URL is “https://demo.nopcommerce.com/”
        String URL = Mydriver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown(){

        closeBrowser();
    }
}

