package AddToCart;

import CheckOut.CheckOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private final WebDriver driver;
    private final By totalItemCount = By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[2]/div[1]/form/div/div/div");
    private final By addItem = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[5]/div/div/div[2]/form/div[4]/button");
    private final By checkOutButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button");

    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Check the number of items in the cart
    public void itemCount(int count) throws InterruptedException
    {
        //Convert value showing quantity of an item from String to integer and store in itemNumber variable
        int itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());

        //Compare the current quantity of an item with the expected quantity and increment until they are equal
        while (itemNumber != count)
        {
            //Click the + button to increase the number of the selected item
            driver.findElement(addItem).click();
            //update the value of the quantity in the variable after the increment
            itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());
        }
        //Wait for the check out button to load
        Thread.sleep(5000);
    }

    //Click on check out button
    public CheckOutPage clickCheckOut() throws InterruptedException
    {
        driver.findElement(checkOutButton).click();
        //Wait for the checkout page to load
        Thread.sleep(7000);
        return new CheckOutPage(driver);
    }
}
