import com.pages.DashBoardPage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void userLogin() throws InterruptedException {
        LoginPage loginPage = pageFactory.getLoginPage();
        loginPage.userLogin("standard_user","secret_sauce");
        DashBoardPage dashBoard = pageFactory.getProductDashBoard();
        System.out.println(dashBoard.getTitleOfThePage());
        Assert.assertTrue(dashBoard.isBurgerMenuPresent(), "Menu not present");
    }

}
