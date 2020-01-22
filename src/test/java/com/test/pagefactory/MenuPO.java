package com.test.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MenuPO<M extends WebElement> extends BasePO<M>{
	
	private static final String MENU_TITLE = "Menu";
	
	public MenuPO() throws Exception
	{
		super();
		setTitle(MENU_TITLE);
	}
	
	// elements
	@FindBy(xpath = "//strong[contains(text(), 'Green Tea')]")
    protected M GreenTea;
	
	@FindBy(xpath = "//strong[contains(text(), 'Red Tea')]")
    protected M RedTea;
	
	@FindBy(xpath = "//strong[contains(text(), 'Oolong Tea')]")
    protected M OolongTea;
	
	@FindBy(xpath = "//strong[contains(text(), 'Check Out')]")
    protected M Checkout;
	
	public CheckoutPO clickCheckout() throws Exception
	{
		/*
		 * This is going to check out page
		 */
		Checkout.click();
		
		return new CheckoutPO();
	}
	
    @Override
    protected void setTitle(String pageTitle)
    {
    	this.pageTitle = pageTitle;
    }
    
    @Override
    protected String getTitle()
    {
    	return this.pageTitle;
    }
  


}
