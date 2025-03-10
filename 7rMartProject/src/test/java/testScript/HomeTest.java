package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "verification of user can log out from the home page")
	public void verifyWhetherUserCanLogOutFromHomePageAfterLoginToThePage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		HomePage home = new HomePage(driver);
		home.clickOnAdminField();
		home.clickOnLogOutField();

		boolean isSignButtonEnabled = home.isSignInButtonEnabled();
		Assert.assertTrue(isSignButtonEnabled, Messages.LOGOUTFROMHOMEPAGEERROR);
	}

}
