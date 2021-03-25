
package SubCategory;

import Search.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {
    private final WebDriver driver;
    private final By searchBar = By.xpath("//input[@type='search']");
    private final By searchButton = By.className("fdd83_39Iap");
    int searchBarElementsID = 1; //The elements on search were more than 1

    public SubCategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchForAnItem(String item)
    {
        //Search for an item on the search bar
        driver.findElements(searchBar).get(searchBarElementsID).sendKeys(item);
    }

    public SearchPage clickSearchButton() throws InterruptedException
    {
        //Click on the search button on the search bar
        driver.findElements(searchButton).get(searchBarElementsID).click();
        Thread.sleep(5000);
        return new SearchPage(driver);
    }
}