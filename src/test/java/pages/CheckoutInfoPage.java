package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;
    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;
    @FindBy(id = "continue")
    private WebElement continueBtn;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void checkoutInfoInput(){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("NetIt");
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Academy");
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys("1000");
        continueBtn.click();
    }
}
