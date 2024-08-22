package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    //This class will provide common functionalities shared among different page objects.
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
}
