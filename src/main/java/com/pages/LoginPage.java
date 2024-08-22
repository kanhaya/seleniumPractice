package com.pages;

import com.pagefactory.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement password;

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public void setUserName(String user){
        userName.sendKeys(user);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void doLogin(){
        //  loginButton.click();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",loginButton);
    }


    public void  userLogin(String user,String password){
        try{
            setUserName(user);
            setPassword(password);
            doLogin();
        }catch (NoSuchElementException elementException){
           elementException.printStackTrace();
        }
    }
}
