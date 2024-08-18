package com.pagefactory;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    protected WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public DashBoardPage getProductDashBoard() {
        return new DashBoardPage(driver);
    }
}
