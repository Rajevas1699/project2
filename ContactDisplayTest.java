package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;
import utils.TestBase;

public class ContactDisplayTest extends TestBase {

    @Test
    public void testContactDetailsDisplayedCorrectly() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage();
        Assert.assertTrue(contactListPage.getContactCount() > 0, "At least one contact should be present");

        // Check that first contact displays name and phone
        String contactText = driver.findElements(By.className("contact")).get(0).getText();
        Assert.assertTrue(contactText.contains("+"), "Phone number should be displayed with extension");
    }
}
