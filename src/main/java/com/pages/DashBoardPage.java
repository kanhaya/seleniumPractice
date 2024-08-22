package com.pages;

import com.pagefactory.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage  extends BasePage {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    public WebElement burgerMenu;

    public DashBoardPage(WebDriver driver){
        super(driver);
    }

    public String getTitleOfThePage(){
        return driver.getTitle();
    }

    public boolean isBurgerMenuPresent() throws InterruptedException {
        return burgerMenu.isDisplayed();
    }

}
