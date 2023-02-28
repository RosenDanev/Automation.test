package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends BasePage {
    private final static String PRODUCT_ID = "add-to-cart-sauce-labs-";

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productTitle;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_ID + itemName));
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait10.until(ExpectedConditions.elementToBeClickable(itemToBeAdded));
        itemToBeAdded.click();
    }
    public int getItemsInTheCart(){
        return Integer.parseInt(cartBadge.getText());
    }
    public void cartBadge(){
        cartBadge.click();
    }
}
