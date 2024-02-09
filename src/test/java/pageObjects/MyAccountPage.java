package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Base{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='content']//h2[contains(text(),'My Account')]")
	WebElement MyAccountmsg;
	@FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	public String displayMyAccMsg() {
		return MyAccountmsg.getText();
		//return MyAccountmsg.isDisplayed();
	}
	public void clickonlogOut() {
		Logout.click();
	}

}
