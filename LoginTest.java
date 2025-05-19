package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

public class LoginTest extends TestBase {

  

	@Test
    public void testLoginButtonIsVisible() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button should be visible");
    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage();
        Assert.assertTrue(((ContactListPage) contactListPage).isLogoutButtonVisible1(), "Logout button should be visible after login");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("wronguser@example.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        // Application should not navigate to contact list
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "User should remain on login page after failure");
    }
}

