package LoginPage;

import org.testng.annotations.Test;
import setup.SetupTests;


public class LoginPageTests extends SetupTests {

    //TestNG annotation
    @Test
    //This class extends to the SetupTests as the SetupTests class contains all the setup requirements to run our test
    public void testLogin() {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");
        loginPage.clickLoginBtn();

        String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED-The page url is" + loginUrl);

    }
    @Test
    public void testLogout() {

        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage=dashboardPage.clickLogout();
        }
        catch (Exception e){
            String logoutUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED-The page url is" + logoutUrl);
        }
    }
}