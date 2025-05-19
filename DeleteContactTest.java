package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;
import utils.TestBase;
import org.openqa.selenium.By;

public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage();
        int countBefore = contactListPage.getContactCount();

        // Click on the first contact
        driver.findElements(By.className("contact")).get(0).click();

        EditContactPage editContactPage = new EditContactPage(driver);
        Assert.assertTrue(editContactPage.isDeleteButtonVisible(), "Delete button should be visible");

        editContactPage.clickDelete();

        // Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        int countAfter = contactListPage.getContactCount();
        Assert.assertTrue(countAfter < countBefore, "Contact should be deleted");
    }
}
