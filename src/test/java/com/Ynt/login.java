package com.Ynt;

import com.Ynt.common.Browsers;
import com.Ynt.common.BrowsersType;
import com.Ynt.common.ParseProperties;
import com.Ynt.functions.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
    private ParseProperties data=new ParseProperties(System.getProperty("user.dir") + "/config/data/parameter.properties");
    private Browsers browsers=null;
    private WebDriver driver=null;
    private Assert judge=null;
    
    @Test
    public void Login() throws InterruptedException
    {
        driver.get(data.getValue("url"));
        Thread.sleep(2000);
        
       judge=new Assert(this.driver);
       
       if(judge.getElement(By.xpath(data.getValue("logoElement")))==true)
       {
           System.out.println("Login success!");
       }
       else 
       {
           System.out.println("Login fail!");
       }
    }

    @BeforeTest
    public void BeforeTest()
    {
        browsers=new Browsers(BrowsersType.chrome);
        driver=browsers.driver;
    }
    
    @AfterTest
    public void AfterTest()
    {
        driver.quit();
    }
}
