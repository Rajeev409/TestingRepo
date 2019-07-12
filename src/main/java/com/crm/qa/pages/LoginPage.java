package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//PageFactory or Object Repository

	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@type,'submit')] ")
	WebElement loginBtn;
	
	
	
	
	
//	@FindBy(xpath="//input[@value='Login']")
//	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
				
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage Login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
	//	loginBtn.click();
		//using java script executor click to click on the login button 
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
		
	}
	
	
}


