package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage{
    @FindBy(xpath = "//*[@class = 'complete-header']")
    private WebElement confirmMsg;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void ConfirmMsgAssert(){
        Assert.assertTrue(confirmMsg.isDisplayed());
    }

}
