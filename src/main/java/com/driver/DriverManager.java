package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

        private static volatile  DriverManager instance;
        private static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

        //making this private for singlton
        private DriverManager(){
        }

    public void setDriver(Browser browser){
        driverThreadLocal.set(BrowserFactory.createWebDriverInstance(browser));
    }

    public static DriverManager getInstance(Browser browser){
        if(instance==null){
            synchronized (DriverManager.class){
                if(instance==null){
                   instance=new DriverManager();
                }
            }
        }
        if(driverThreadLocal.get()==null){
           instance.setDriver(browser);
        }
        return instance;
    }


    public WebDriver getDriver(){
            return driverThreadLocal.get();
    }

    public static void quitDriver(){
        if (driverThreadLocal!=null){
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
