
package Search;

import AddToCart.AddToCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final WebDriver driver;
    private final By AddToCartButton = By.xpath("//button[@class='_0a08a_3czMG']");
    private final By MyCartButton= By.xpath("//a[@class='_79484_1sLEt _7ad32_SD12Y _16536_xxIKG']");

    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click the first Add to cart button
    public void clickOnAddToCart(int index) throws InterruptedException
    {
        driver.findElements(AddToCartButton).get(index - 1).click();
        Thread.sleep(5000);
    }

    //Click My Cart Button
    public AddToCartPage clickMyCartButton() throws InterruptedException
    {
        driver.findElement(MyCartButton).click();
        Thread.sleep(3000);
        return new AddToCartPage(driver);
    }



}
