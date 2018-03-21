package com.Ynt.functions;

import com.Ynt.common.ParseProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class modelPage {
    protected WebDriver driver=null;
    private ParseProperties data=null;
    
    public modelPage(WebDriver driver)
    {
        this.driver=driver;
        data=new ParseProperties(System.getProperty("user.dir")+"\\config\\data\\parameter.properties");
    }
    
    public WebElement elementLocator(By element)
    {
        return this.driver.findElement(element);
    }
    public void createModel(String modelName,String ruleName,String ruleType,String[] keyWords)throws InterruptedException
    {
        this.elementLocator(By.xpath(data.getValue("element_Model"))).click();
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("element_ModelName"))).sendKeys(data.getValue(modelName));
       
        this.elementLocator(By.xpath(data.getValue("element_RuleName"))).sendKeys(data.getValue(ruleName));
        Thread.sleep(1000);
        
        this.elementLocator(By.xpath(data.getValue("element_ruleType"))).click();
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue(ruleType))).click();
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("element_NextStep"))).click();
        Thread.sleep(1000);
        
        setRule(keyWords);
    }
    public void deleteModel(String modelName)throws InterruptedException
    {
        this.elementLocator(By.xpath(data.getValue("element_checkbox").replace("%var%",data.getValue(modelName)))).click();
        this.elementLocator(By.xpath(data.getValue("element_deleteButton"))).click();
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("element_confirm"))).click();
        Thread.sleep(2000);
    }
    public void setRule(String[] keyWords)throws InterruptedException
    {
        /*
        Iterator iterator=keyWords.iterator();
        while (iterator.hasNext())
        this.elementLocator(By.xpath(data.getValue("element_addKeywords"))).sendKeys(iterator.next().toString());
        this.elementLocator(By.xpath(data.getValue("element_addKeywords"))).sendKeys(Keys.ENTER);
        */
        for (String keyWord:keyWords) {
            this.elementLocator(By.xpath(data.getValue("element_addKeywords"))).sendKeys(keyWord);
            this.elementLocator(By.xpath(data.getValue("element_addKeywords"))).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        }
        
        this.elementLocator(By.xpath(data.getValue("element_NextStep2"))).click();
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("element_returnModelList"))).click();
        Thread.sleep(2000);
    }
    
}
