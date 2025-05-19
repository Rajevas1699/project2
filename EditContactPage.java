package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditContactPage {
    WebDriver driver;

    // Elements (same IDs as AddContactPage)
    @FindBy(id = "firstName") private WebElement firstName;
    @FindBy(id = "lastName") private WebElement lastName;
    @FindBy(id = "birthdate") private WebElement birthdate;
    @FindBy(id = "email") private WebElement email;
    @FindBy(id = "phone") private WebElement phone;
    @FindBy(id = "street1") private WebElement street1;
    @FindBy(id = "street2") private WebElement street2;
    @FindBy(id = "city") private WebElement city;
    @FindBy(id = "stateProvince") private WebElement stateProvince;
    @FindBy(id = "postalCode") private WebElement postalCode;
    @FindBy(id = "country") private WebElement country;

    @FindBy(id = "submit") private WebElement saveButton;
    @FindBy(xpath = "//button[text()='Delete']") private WebElement deleteButton;

    // Constructor
    public EditContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void clearAndUpdateFirstName(String value) {
        firstName.clear();
        firstName.sendKeys(value);
    }

    public void clearAndUpdateLastName(String value) {
        lastName.clear();
        lastName.sendKeys(value);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public boolean isDeleteButtonVisible() {
        return deleteButton.isDisplayed();
    }
}
