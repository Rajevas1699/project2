package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;
import utils.TestBase;

public class AddContactTest extends TestBase {

    @Test
    public void testAddContactWithAllFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage();
        contactListPage.clickAddContact();

        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.setFirstName("Alex");
        addContactPage.setLastName("Brown");
        addContactPage.setBirthdate("01/01/2000");
        addContactPage.setEmail("alex.brown" + System.currentTimeMillis() + "@mail.com");
        addContactPage.setPhone("1234567890");
        addContactPage.setStreet1("Street 1");
        addContactPage.setCity("City");
        addContactPage.setStateProvince("State");
        addContactPage.setPostalCode("123456");
        addContactPage.setCountry("Country");
        addContactPage.clickSubmit();

        // Validate new contact was added by checking contact list count > 0
        Assert.assertTrue(contactListPage.getContactCount() > 0, "New contact should be added");
    }

    @Test
    public void testAddContactWithMissingOptionalFields() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();

        ContactListPage contactListPage = new ContactListPage();
        contactListPage.clickAddContact();

        AddContactPage addContactPage = new AddContactPage(driver);
        addContactPage.setFirstName("Tom");
        addContactPage.setLastName("K");
        addContactPage.setEmail("tom.k" + System.currentTimeMillis() + "@mail.com");
        addContactPage.clickSubmit();

        Assert.assertTrue(contactListPage.getContactCount() > 0, "Contact should be added without optional fields");
    }
}
