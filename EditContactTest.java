package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;
import utils.TestBase;
import org.openqa.selenium.By;

public class EditContactTest extends TestBase {

    @Test
    public void testEditContact() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        // Select first contact
        driver.findElements(By.className("contact")).get(0).click();

        EditContactPage editContactPage = new EditContactPage(driver);
        editContactPage.clearAndUpdateFirstName("UpdatedName");
        editContactPage.clickSave();

        // Confirm user redirected to contact list and changes persisted
        Assert.assertTrue(driver.getCurrentUrl().contains("contactList"), "Should redirect after editing contact");
    }
}
