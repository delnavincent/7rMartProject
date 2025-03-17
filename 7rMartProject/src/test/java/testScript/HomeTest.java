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

	@Test(description = "verification of user can log out from the home page", retryAnalyzer = retry.ReTry.class)
	public void verifyWhetherUserCanLogOutFromHomePageAfterLoginToThePage() throws IOException {
		HomePage home;

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		home.clickOnAdminField();
		login = home.clickOnLogOutField();
		boolean isSignButtonEnabled = home.isSignInButtonEnabled();
		Assert.assertTrue(isSignButtonEnabled, Messages.LOGOUTFROMHOMEPAGEERROR);
	}

}
