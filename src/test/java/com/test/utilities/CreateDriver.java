package com.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CreateDriver {
	
	private static CreateDriver instance = null;
	private static final int IMPLICIT_TIMEOUT = 0;
//	private static WebDriver webDriver = new WebDriver();
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

//	private String getEnv = null;
	private Properties props = new Properties();
	
	private CreateDriver()
	{
		
	}
	
	public static CreateDriver getInstance()
	{
		if(instance == null)
		{
			instance = new CreateDriver();
		}
		return instance;
	}
	
	public final void setDriver(String browser, String platform) throws IOException
	{
		DesiredCapabilities caps = null;
//		String getPlatform = null;
		props.load(new FileInputStream(Global_VARS.SE_PROPS));
		
		caps = DesiredCapabilities.chrome();
		
		ChromeOptions chOptions = new ChromeOptions();
		
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		chOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		chOptions.setExperimentalOption("prefs", chromePrefs);
		
		chOptions.addArguments("--disable-plugins", "--disable-extentions", "--disable-popup-bloacking");
		
		caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
		caps.setCapability("applicationCacheEnabled", false);
		
		System.setProperty("webdriver.chrome.driver", props.getProperty("chrome.driver.path"));
		webDriver.set(new ChromeDriver(chOptions.merge(caps)));
		
		getDriver().manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
	
		
	}
	
	public WebDriver getDriver()
	{
		return webDriver.get();
	}
	
	public void closeDriver()
	{
		try
		{
			getDriver().quit();
		}catch(Exception e)
		{
			System.out.println("driver not closing");
		}
		
	}

}
