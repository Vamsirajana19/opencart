package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountRegistrationPage {
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	WebElement registerAccount;
	
	@FindBy(id="input-firstname")
	WebElement First_Name;
	
	@FindBy(id="input-lastname")
	WebElement Last_Name;
	
	@FindBy(id="input-email")
	WebElement Email;
	
	@FindBy(id="input-telephone")
	WebElement telePhone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmpassword;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
	WebElement newsLetter;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//h1")
	WebElement ConfirmationMsg;
	
	public String displayRegisterAccount() {
		String text =registerAccount.getText();
		Assert.assertEquals("Register Account",text);
		return text;
	}
	
	public void setfirstname(String fname) {
		First_Name.sendKeys(fname);
	}
	public void setlastname(String lname) {
		Last_Name.sendKeys(lname);
	}
	public void setemail(String email) {
		Email.sendKeys(email);
	}
	public void settelephone(String tele) {
		telePhone.sendKeys(tele);
	}
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void setconfirmpassword(String cnfrmpwd) {
		confirmpassword.sendKeys(cnfrmpwd);
	}
	public void clicknewsletter() {
//		if(newsLetter.isSelected()) {
//			System.out.println("NewsLetter is Selected");
//		}else
		newsLetter.click();
	}
	public void privacypolicy() {
//		privacyPolicy.clear();
		privacyPolicy.click();
	}
	public void Continue() {
		submit.click();
	}
	public String getConfirmationMsg() {
		String msg = ConfirmationMsg.getText();
		//Assert.assertEquals("Your Account Has Been Created!",msg);
		return msg;
	}
}
