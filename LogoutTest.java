package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.ContactListPage;
import utils.TestBase;

public class LogoutTest extends TestBase {

    @Test
    public void testLogoutFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage(driver);
        Assert.assertTrue(contactListPage.isLogoutButtonVisible(), "Logout button should be visible");

        contactListPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "User should return to login page after logout");
    }
}
