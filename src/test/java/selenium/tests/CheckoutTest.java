package selenium.tests;

import Base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends TestUtil {

    @Test
    public void checkOut(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login("standard_user","secret_sauce");
        prPage.addItemToTheCart("backpack");
        prPage.cartBadge();
        CartPage cartPage = new CartPage(driver);
        cartPage.checkoutClick();
        CheckoutInfoPage checkOutInfo = new CheckoutInfoPage(driver);
        checkOutInfo.checkoutInfoInput();
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.overviewConfirm();
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        //Assert
        completePage.ConfirmMsgAssert();
    }
}
