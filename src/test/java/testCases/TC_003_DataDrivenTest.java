package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_DataDrivenTest extends BaseClass {
	@Test(dataProvider = "loginData",dataProviderClass=DataProviders.class)
	public void DataTests(String email, String pwd, String expectedRes) {
		logger.info("***** Started DataDriven Test *****");
		//logger.debug("Started Debugging of Application");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickonMyAccount();
			logger.info("Clicked on MyAccount");
			hp.clickonLogin();
			logger.info("Clicked on Login");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info("Set Email");
			lp.setPassword(pwd);
			logger.info("Set Password");
			lp.clickonLogin();
			logger.info("Clicked on Login");
			MyAccountPage myacc = new MyAccountPage(driver);
			//Assert.assertEquals("My Account", myaccmsg);
			String myaccmsgg = myacc.displayMyAccMsg();
			if(expectedRes.equalsIgnoreCase("valid")) {
				if(myaccmsgg.equalsIgnoreCase("My Account")){
					myacc.clickonlogOut();
					logger.info("Clicked on Logout");
					System.out.println("Valid Account");
					//Assert.assertTrue(true);
				}else {
					System.out.println("Valid Account, MyAccount not Displayed");
					//Assert.assertTrue(false);
				}
//				if(targetPage==true)
//				{
//					myacc.clickonlogOut();
//					System.out.println("Valid Passed");
//					Assert.assertTrue(true);
//				}
//				else if(targetPage!=true)
//				{
//					System.out.println("Valid Failed");
//					Assert.assertTrue(false);
//				}
			}
			if(expectedRes.equalsIgnoreCase("invalid")) {
				if(myaccmsgg.equalsIgnoreCase("My Account")){
					myacc.clickonlogOut();
					System.out.println("Invalid Account, MyAccount Displayed");
					//Assert.assertTrue(false);
				}else {
					System.out.println("Invalid Account, MyAccount not Displayed");
					//Assert.assertTrue(true);
				}
//				if(targetPage==true)
//				{
//					
//					myacc.clickonlogOut();
//					System.out.println("Invalid Failed");
//					Assert.assertTrue(false);
//				}
//				else
//				{
//					System.out.println("Invalid Passed");
//					Assert.assertTrue(true);
//				}
			}
		}catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
}
