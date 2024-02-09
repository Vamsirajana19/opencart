package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
	WebElement DisplayLoginPage;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;
	
	public String confirmLoginPage() {
		return DisplayLoginPage.getText(); 
	}
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickonLogin() {
		login.click();
	}

}
