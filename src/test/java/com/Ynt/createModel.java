package com.Ynt;

import com.Ynt.common.Browsers;
import com.Ynt.common.BrowsersType;
import com.Ynt.common.ParseProperties;
import com.Ynt.functions.Assert;
import com.Ynt.functions.modelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class createModel {
    private ParseProperties data=new ParseProperties(System.getProperty("user.dir")+"/config/data/parameter.properties");
    private WebDriver driver=null;
    private Browsers browsers=null;
    private modelPage mp=null;
    private Assert judge=null;

    
    @BeforeTest
    public void BeforeTest() throws InterruptedException
    {
        browsers=new Browsers(BrowsersType.chrome);
        this.driver=browsers.driver;
        this.driver.get(data.getValue("url"));
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

    @Test
    public void CreateModel()throws InterruptedException
    {
        mp=new modelPage(this.driver);
        String[] keyWords={"话费","套餐","流量","9月份","中国移动"};
        mp.createModel( "modelName","ruleName","ruleType",keyWords);
       
    }
    
    @AfterTest
    public void AfterTest()throws InterruptedException
    {
        mp.deleteModel("modelName");
        this.driver.quit();
    }
}
