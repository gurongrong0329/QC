package com.Ynt.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class Assert extends modelPage{
    
    public Assert(WebDriver driver)
    {
        super(driver);
    }
    
    public WebElement elementLocator(By element)
    {
        return this.driver.findElement(element);
    }
    
    public boolean getElement(By element)
    {
        try {
            this.elementLocator(element);
            return true;
        }catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
