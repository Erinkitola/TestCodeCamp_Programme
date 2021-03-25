package Login;
import Home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By nameOfUser = By.id("username");
    private final By passwordOfUser = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Enter Username
    public void enterUsername(String hostName)
    {
        driver.findElement(nameOfUser).sendKeys(hostName);
    }

    //Enter Password
    public void enterPassword(String hostPassword)
    {
        driver.findElement(passwordOfUser).sendKeys(hostPassword);
    }

    //Click on the Login button
    public void clickLoginButton() throws InterruptedException
    {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        new HomePage(driver);
    }

}
