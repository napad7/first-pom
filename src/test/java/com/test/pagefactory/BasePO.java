package com.test.pagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.utilities.BrowserUtilities;
import com.test.utilities.CreateDriver;
import com.test.utilities.Global_VARS;

public abstract class BasePO<M extends WebElement> {

	protected String pageTitle = "";
	
	public BasePO() throws Exception
	{
		PageFactory.initElements(CreateDriver.getInstance().getDriver(), this);
	}
	
	//elements
	@FindBy(css = "img[src*='01e56eb76d18b60c5fb3dcf451c080a1']")
    protected M passionTeaCoImg;

    @FindBy(css = "img[src*='ab7db4b80e0c0644f5f9226f2970739b']")
    protected M leafImg;

    @FindBy(css = "img[src*='cd390673d46bead889c368ae135a6ec2']")
    protected M organicImg;

    @FindBy(css = "a[href='welcome.html']")
    protected M welcome;

    @FindBy(css = "(//a[@href='menu.html'])[2]")
    protected M menu;

    @FindBy(css = "a[href='our-passion.html']")
    protected M ourPassion;

    @FindBy(css = "a[href='let-s-talk-tea.html']")
    protected M letsTalkTea;

    @FindBy(css = "a[href='check-out.html']")
    protected M checkOut;

    @FindBy(css = "//p[contains(text(),'Copyright')]")
    protected M copyright;
    
    protected abstract void setTitle(String pageTitle);
    protected abstract String getTitle();
    
    public void verifyTitle (String title) throws AssertionError
    {
    	WebDriver driver = CreateDriver.getInstance().getDriver();
    	
    	assertEquals(driver.getTitle(), title, "Verify Page Title");
    }
    
    public void navigate(String page)
    {
    	WebDriver driver = CreateDriver.getInstance().getDriver();
    	
    	BrowserUtilities.waitForClickable(By.xpath("//a[contains(text(),'"+ page + "')]"), Global_VARS.TIMEOUT_MINUTE);
    	
    	driver.findElement(By.xpath("//a[contains(text(), '"+ page +"')]")).click();
    	
    	BrowserUtilities.waitFor(this.getTitle(), Global_VARS.TIMEOUT_ELEMENT);
    	
    }
	
    public void loadPage(String url, int timeout) {
    	WebDriver driver = CreateDriver.getInstance().getDriver();
    	driver.navigate().to(url);
    	
    	//wait for URL
    	BrowserUtilities.waitForURL(Global_VARS.TARGET_URL, timeout);
    }
    
    public void selectFromDropDown(By by, String option)
    {
    	WebDriver driver = CreateDriver.getInstance().getDriver();
    	Select topDropDown = new Select(driver.findElement(by));
    	topDropDown.deselectByVisibleText(option);
    	BrowserUtilities.waitFor(this.getTitle(), Global_VARS.TIMEOUT_ELEMENT);
    }
	
    
    
}
