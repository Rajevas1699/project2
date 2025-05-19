package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {
    WebDriver driver;

    // Elements
    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "birthdate")
    private WebElement birthdate;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "street1")
    private WebElement street1;

    @FindBy(id = "street2")
    private WebElement street2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "stateProvince")
    private WebElement stateProvince;

    @FindBy(id = "postalCode")
    private WebElement postalCode;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "submit")
    private WebElement submitButton;

    // Constructor
    public AddContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void setFirstName(String value) { firstName.sendKeys(value); }
    public void setLastName(String value) { lastName.sendKeys(value); }
    public void setBirthdate(String value) { birthdate.sendKeys(value); }
    public void setEmail(String value) { email.sendKeys(value); }
    public void setPhone(String value) { phone.sendKeys(value); }
    public void setStreet1(String value) { street1.sendKeys(value); }
    public void setStreet2(String value) { street2.sendKeys(value); }
    public void setCity(String value) { city.sendKeys(value); }
    public void setStateProvince(String value) { stateProvince.sendKeys(value); }
    public void setPostalCode(String value) { postalCode.sendKeys(value); }
    public void setCountry(String value) { country.sendKeys(value); }

    public void clickSubmit() { submitButton.click(); }

    public boolean isSubmitButtonVisible() {
        return submitButton.isDisplayed();
    }
}
