package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups = {"regression","master"})
	public void verify_account_registration(){
		logger.info("**********verify_account_registration**********");
		logger.info("**********Started TC_001_AccountRegistrationTest**********");
		logger.debug("Application Logs");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickonMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickonRegister();
		logger.info("Clicked on Registration Link");
		logger.info("Entering Customer Details");
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		String t = ap.displayRegisterAccount();
		System.out.println(t);
		ap.setfirstname(generateRandomString().toUpperCase());
		ap.setlastname(generateRandomString().toUpperCase());
		ap.setemail(generateRandomString()+"@gmail.com");
		ap.settelephone(generateRandomNumeric());
		String password = generateRandomNumeric();
		ap.setpassword(password);
		ap.setconfirmpassword(password);
		ap.clicknewsletter();
		ap.privacypolicy();
		ap.Continue();
		logger.info("Clicked on Continue");
		logger.info("Validating Expected Message");
		String msg = ap.getConfirmationMsg();
		if(msg.equals("Your Account Has Been Created!")) {
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed");
			Assert.fail();
		}
		
		}catch (Exception e) {
			logger.error("test fail");
			Assert.fail();
		}
		logger.info("**********Finished TC_001_AccountRegistrationTest**********");
	}
	

}
