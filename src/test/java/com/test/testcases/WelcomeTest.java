package com.test.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pagefactory.WelcomePO;
import com.test.utilities.CreateDriver;
import com.test.utilities.Global_VARS;

public class WelcomeTest {
	
	private WelcomePO<WebElement> welcome = null;
	
	public WelcomeTest() throws Exception {}
	
	@Parameters({"browser", "platform"})
	@BeforeTest(alwaysRun = true, enabled = true)
	protected void testSetup(@Optional String browser, @Optional String platform) throws Exception
	{
	
		Global_VARS.DEF_BROWSER = System.getProperty("browser", browser);
		Global_VARS.DEF_PLATFORM = System.getProperty("platform", platform);
		
		CreateDriver.getInstance().setDriver(Global_VARS.DEF_BROWSER, Global_VARS.DEF_PLATFORM);
	}
	
	@AfterTest(alwaysRun = true, enabled =true)
	protected void testTearDown()
	{
		CreateDriver.getInstance().closeDriver();
	}

	
	@BeforeClass(alwaysRun = true, enabled = true)
	protected void testClassSetup() throws Exception
	{
		welcome = new WelcomePO<WebElement>();
		welcome.loadPage(Global_VARS.TARGET_URL, Global_VARS.TIMEOUT_MINUTE);
	}
	
	@AfterClass(alwaysRun = true, enabled = true)
	protected void testClassTeardown() throws Exception
	{}
	
	@BeforeMethod(alwaysRun = true, enabled = true)
	protected void testMethodSetup() throws Exception
	{}
	
	@AfterMethod(alwaysRun = true, enabled = true)
	protected void testMethodTeardown() throws Exception
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		if(!driver.getCurrentUrl().contains("welcome.html"))
		{
			welcome.setTitle("Welcome");
			welcome.navigate("Welcome");
		}
	}
	
	@Test(enabled = true)
	public void tc001_passionTeaCo() throws Exception
	{
//		welcome.setTitle("Welcome");
		welcome.navigate("Welcome"); //going to the welcome page
		welcome.verifyTitle("Welcome");
	}
	
	@Test(enabled= true)
	public void tc002_navigateLink()
	{
		welcome.navigateMenuLink();
	}
	
}
