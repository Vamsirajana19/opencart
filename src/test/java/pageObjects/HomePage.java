package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement Myaccount;
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement Register;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[2]")
	WebElement Login;
	public void clickonMyAccount() {
		Myaccount.click();
	}
	public void clickonRegister() {
		Register.click();
	}
	public void clickonLogin() {
		Login.click();
	}

}
