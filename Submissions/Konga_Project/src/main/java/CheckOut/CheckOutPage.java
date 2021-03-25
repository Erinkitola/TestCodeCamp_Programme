package CheckOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private final WebDriver driver;
    private final By addressButton = By.xpath("//*[@id=\"mainContent\"]/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/button");
    private final By payNowButton = By.xpath("//button[@data-payment-method='kpaygateway']");
    private final By continueToPaymentButton = By.xpath("//button[@value='kpaygateway']");
    private final By checkOut_iFrame = By.xpath("//*[@id='kpg-frame-component']");
    private final By cardButton = By.cssSelector(".Card");
    private final By cardNumberField = By.xpath("//*[@id='card-number']");
    private final By dateField = By.id("expiry");
    private final By cvvField = By.id("cvv");
    private final By invalidMessage = By.xpath("//*[@id='card-number_unhappy']");
    private final By cardPin = By.xpath("//input[@id='card-pin-new']");

    public CheckOutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnPayNow()
    {
        driver.findElement(payNowButton).click();
    }

    public void clickContinueToPayment() throws InterruptedException
    {
        driver.findElements(continueToPaymentButton).get(1).click();
        Thread.sleep(10000);
    }

    //Select the Payment Type
    public void clickOnPaymentType() throws InterruptedException
    {
        WebElement checkOutFrame = driver.findElement(checkOut_iFrame);
        //Switch to iFrame
        driver.switchTo().frame(checkOutFrame);
        driver.findElement(cardButton).click();
        Thread.sleep(3000);
    }

    //Enter card details
    public void enterCardDetails(String cardNumber, String date, String cvv)
    {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(cvvField).sendKeys(cvv);
    }

    //Click  on the pin field
    public void clickOnPinField()
    {
        driver.findElement(cardPin).click();
    }

    //Click the entered pin
    public void clickOnPin(int pinEntered)
    {
        System.out.println("Value entered is invalid");
    }

    //Return User invalid message
    public String invalid_message()
    {
        return driver.findElement(invalidMessage).getText();
    }

    public By getAddressButton() {
        return addressButton;
    }
}