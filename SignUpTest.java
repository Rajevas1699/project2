package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.SignUpPage;
import utils.TestBase;

public class SignUpTest extends TestBase {

    @Test
    public void testSignUpButtonVisibleAndClickable() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isSignUpLinkVisible(), "Signup link should be visible");

        loginPage.clickSignUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.isSignUpButtonVisible(), "Signup button should be visible on SignUp Page");
    }

    @Test
    public void testValidSignup() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("John");
        signUpPage.setLastName("Doe");
        signUpPage.setEmail("john.doe" + System.currentTimeMillis() + "@example.com");
        signUpPage.setPassword("Password123");
        signUpPage.clickSignUp();

        Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), "Should redirect to contact list after signup");
    }
}
