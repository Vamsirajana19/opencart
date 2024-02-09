package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups = {"sanity","master"})
	public void LoginTest() {
		logger.info("***** Started Login Test *****");
		logger.debug("Started Debugging of Application");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickonMyAccount();
			logger.info("Clicked on MyAccount");
			hp.clickonLogin();
			logger.info("Clicked on Login");
			LoginPage lp = new LoginPage(driver);
			String confrmlgnpage = lp.confirmLoginPage();
			Assert.assertEquals("Returning Customer",confrmlgnpage);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickonLogin();
			logger.info("Clicked on Login");
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished Login Test *****");
	}
}
