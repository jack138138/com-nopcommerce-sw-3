package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class TestSuite extends Utility {
    String MyUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(MyUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));
        //Click on Desktop (Image)
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops'] "));

        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), ("Name: Z to A"));

        //Verify the Product will arrange in Descending order.
        String expectedOrder = "Name: Z to A";
        String actualOrder = Mydriver.findElement(By.xpath("//option[contains(text(),'Name: Z to A')]")).getText();
        Assert.assertEquals("Error in Order", expectedOrder, actualOrder);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));
        //Click on Desktop (Image)
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops'] "));

        //Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(1000);

        //Click on add to cart button

        clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));

        //Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = Mydriver.findElement(By.xpath("//h1[contains (text(),  'Build your own computer')]")).getText();
        Assert.assertEquals("Wrong Text", expectedText, actualText);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"), ("2.2 GHz Intel Pentium Dual-Core E2200"));

        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"), ("8GB [+$60.00]"));

        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id = 'product_attribute_3_7']"));

        // Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id = 'product_attribute_4_9']"));

        Thread.sleep(1000);


        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.xpath("//input[@id = 'product_attribute_5_12']"));
        String expectedValue = "$1,475.00";
        String actualValue = getTextFromElement(By.xpath("//span[@id = 'price-value-1']"));
        //Assert.assertEquals("Wrong Value Shown", expectedValue,actualValue);

        //Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top Green Bar

        String expectedTexts = "The product has been added to your shopping cart";
        String actualTexts = getTextFromElement(By.xpath("//p[@class = 'content']"));
        Assert.assertEquals("Wrong Text Shown in Green Bar", expectedTexts, actualTexts);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class = 'close']"));

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElement(By.xpath("//span[@class = 'cart-label']"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //Verify the message "Shopping cart
        String expectedMSG = "Shopping cart";
        String actualMSG = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Wrong MSG Shown", expectedMSG, actualMSG);

        Thread.sleep(1000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement quantity = Mydriver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
        quantity.clear();
        quantity.sendKeys("2");
        Thread.sleep(2000);
        clickOnElement(By.id("updatecart"));
        Thread.sleep(1000);

        //Verify the Total"$2,950.00"
        String expectedValueText = "$2,950.00";
        String actualValueText = getTextFromElement(By.xpath("//span[@class= 'value-summary'] //strong[contains(text(), '$2,950.00')]"));
        Assert.assertEquals("Wrong Value Shown", expectedValueText, actualValueText);

        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@name='termsofservice']"));

        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Wrong Text Shown", expectedWelcomeText, actualWelcomeText);

        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(1000);
        //Fill the all mandatory field

        Thread.sleep(1000);
        Mydriver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Jack");
        // sendTextToElement(By.id("BillingNewAddress_FirstName"), "Jack");

        Mydriver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Sparrow");
        //   sendTextToElement(By.id("BillingNewAddress_LastName"),"Sparrow");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_Email")).sendKeys("CaptaionJack@gmail.com");
        // sendTextToElement(By.id("BillingNewAddress_Email"),"CaptaionJack@gmail.com");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Vikings Associates");
        // sendTextToElement(By.id("BillingNewAddress_Company"),"Vikings Associates");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United Kingdom");
        //selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"Portugal");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        // sendTextToElement(By.id("BillingNewAddress_City"),"London");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Lisbon");
        //sendTextToElement(By.id("BillingNewAddress_Address1"),"Lisbon");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("DA157YN");
        //sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"DA157YN");
        Thread.sleep(1000);

        Mydriver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("12345868");
        //sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"12345868");
        Thread.sleep(1000);

        // Click on “CONTINUE”
        //Mydriver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);

        //Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Assert.assertEquals("Wrong Method Shown", expectedMethod, actualMethod);

        Thread.sleep(1000);

        //Verify “Shipping Method” is “Next Day Air"
        String expectedShippingMethod = "“Next Day Air";
        String actualShippingMethod = getTextFromElement(By.partialLinkText("Next Day Air"));
        Assert.assertEquals("Not Matching Text", expectedShippingMethod, actualShippingMethod);

        //Click to continue
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //Click to continue on credit card
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));

        //fill the details in payment information
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), ("Jack Sparrow"));

        //fill card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), ("2598465565854587"));

        //select Expiration date and Year
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), ("06"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), ("2025"));

        //fill Card Code box
        sendTextToElement(By.xpath("//input[@id='CardCode']"), ("2564"));

        //Click on continue button
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));

        //VERIFY TOTAL $2,950.00

        String expectedValue1 = "$2,950.00";
        String actualValue1 = getTextFromElement(By.xpath("//strong[contains (text(), '$2,950.00')]"));
        Assert.assertEquals("Wrong Value Shown", expectedValue1, actualValue1);

        //Click on confirm
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //Verify Text Thank you

        String expectedThanks = "";
        String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Wrong Message display", expectedThanks, actualThanks);

        //Verify the message “Your order has been successfully processed!”
        String expectedProceed = "Your order has been successfully processed!";
        String actualProceed = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //Click on Continue

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //Verify the text “Welcome to our store"
        String expectedStore = "Welcome to our store";
        String actualStore = getTextFromElement(By.xpath("Welcome to our store"));
        Assert.assertEquals("Wrong message on Welcome", expectedStore, actualStore);


    }

    @After
    public void tearDown() {

        closeBrowser();


    }

}
