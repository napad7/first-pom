package com.test.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.utilities.BrowserUtilities;
import com.test.utilities.CreateDriver;
import com.test.utilities.Global_VARS;

public class WelcomePO<M extends WebElement> extends BasePO<M>{

	private static final String WELCOME_TITLE = "Welcome";
	private static final String MENU_TITLE = "Menu";
	
	
	public WelcomePO() throws Exception
	{
		super();
		setTitle(WELCOME_TITLE);
	}
	
	// elements
    @FindBy(css = "img[src*='7cbbd331e278a100b443a12aa4cce77b']")
    protected M teaCupImg;

    @FindBy(xpath = "//h1[contains(text(),'We're passionate about tea')]")
    protected M caption;

    @FindBy(xpath = "//span[contains(text(),'For more than 25 years')]")
    protected M paragraph;

    @FindBy(css = "a[href='http://www.seleniumframework.com']")
    protected M seleniumFramework;

    @FindBy(xpath = "//span[.='Herbal Tea']")
    protected M herbalTea;

    //<span class="editor_collections">Loose Tea</span>
    //checkout use of xpath if there is single html tag
    @FindBy(xpath = "//span[.='Loose Tea']")
    protected M looseTea;

    @FindBy(xpath = "//span[.='Flavored Tea']")
    protected M flavoredTea;

//	<img src="//nebula.wsimg.com/d892360c0e73575efa3e5307c619db41?AccessKeyId=7ECBEB9592E2269F1812&amp;disposition=0&amp;alloworigin=1" alt="" style="vertical-align:middle;width:146px;height:150px;">
//  notice no //
    @FindBy(css = "img[src*='d892360c0e73575efa3e5307c619db41']")
    protected M herbalTeaImg;

    @FindBy(css = "img[src*='18f9b21e513a597e4b8d4c805321bbe3']")
    protected M looseTeaImg;

    @FindBy(css = "img[src*='d0554952ea0bea9e79bf01ab564bf666']")
    protected M flavoredTeaImg;

//    checkout how to select particular if more than one item coming for xpath
    @FindBy(xpath = "(//span[contains(@class,'button-content')])[1]")
    protected M flavoredTeaCollect;

    @FindBy(xpath = "(//span[contains(@class,'button-content')])[2]")
    protected M herbalTeaCollect;

    
    @FindBy(xpath = "(//span[contains(@class,'button-content')])[3]")
    protected M looseTeaCollect;
    
    //<a href="menu.html" target="" data-title="Menu" data-pageid="00000000-0000-0000-0000-000009816342" data-url="menu.html">Menu</a>
    //checkout using two value in xpath
    @FindBy(xpath="//a[@data-title='Menu' and @data-url='menu.html']")
    protected M menuLink;
//    a[contains(text(), 'Menu')]  
      
    
  
	public void navigateMenuLink()
	{
//		WebDriver driver = CreateDriver.getInstance().getDriver();
        menuLink.click();
        BrowserUtilities.waitFor(MENU_TITLE, Global_VARS.TIMEOUT_ELEMENT);

//        try {
//            driver.findElement(By.xpath(query)).click();
//            menuLink.click();
//            BrowserUtilities.waitFor(MENU_TITLE, Global_VARS.TIMEOUT_ELEMENT);
//        }
//
//        make 2nd attempt with JavaScript API click
//        catch(TimeoutException e) {
//            BrowserUtilities.click(By.xpath(query));
//            BrowserUtilities.waitFor(MENU_TITLE, Global_VARS.TIMEOUT_ELEMENT);
//        }
//
//        assertEquals(MENU_TITLE, title, "Navigate Menu Link");
//		
	}
    
    @Override
    public void setTitle(String pageTitle)
    {
    	this.pageTitle = pageTitle;
    }
    
    @Override
    public String getTitle()
    {
    	return this.pageTitle;
    }
}
