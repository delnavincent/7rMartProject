package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {

	@Test(priority = 1, description = "verification of user can enter new  admin users informations by clicking New button")
	public void verifyWhetherUserIsAbleToAddNewUsersToUsersList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		AdminUserPage adminUser1 = new AdminUserPage(driver);
		adminUser1.clickOnAdminUserField();
		adminUser1.clickOnManageUserField();
		adminUser1.clickOnNewUserField();
		FakerUtility faker=new FakerUtility();
		String adminUsername = faker.createRandomUsername();
		adminUser1.enterAdminUsernameOnUsernameField(adminUsername);
		String adminPassword = faker.createRandomPassword();
		adminUser1.enterAdminPasswordOnPasswordField(adminPassword);
		adminUser1.selectUserTypeOnUserTypeField();
		adminUser1.clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = adminUser1.getTextFromNewUserAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.ADDNEWUSERERROR);

	}

	@Test(priority = 2, description = "verification of user can search admin users in AdminUsers list by clicking Search button")
	public void verifyWhetherUsersIsAbleToSearchNewlyAddedUsersInTheNewlyAddedUsersList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		AdminUserPage adminUser1 = new AdminUserPage(driver);
		adminUser1.clickOnAdminUserField();
		adminUser1.clickOnManageUserField();
		adminUser1.clickOnSearchuserField();
		String adminUserName = ExcelUtility.readStringData(1, 0, "AdminUsersPage");
		adminUser1.enterAdminUsernameToSearch(adminUserName);
		adminUser1.selectTheUserTypeToSearch();
		adminUser1.clickOnSearchButton();

		boolean isSubTitleOfSearchAdminUserPageDisplayed = adminUser1.isSubTitleOfSearchAdminUserPageIsDisplayed();
		Assert.assertTrue(isSubTitleOfSearchAdminUserPageDisplayed, Messages.SEARCHNEWUSERERROR);

	}

	@Test(priority = 3, description = "verification of user can refresh AdminUsers page by clicking Reset button")
	public void verifyUsersIsAbleToRefreshNewlyAddedUsersPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		AdminUserPage adminUser1 = new AdminUserPage(driver);
		adminUser1.clickOnAdminUserField();
		adminUser1.clickOnManageUserField();
		adminUser1.clickOnResetButton();

		boolean isTitleDisplayedOnAdminUsersResetPage = adminUser1.isTitleDisplayedOnAdminUsersResetPage();
		Assert.assertTrue(isTitleDisplayedOnAdminUsersResetPage, Messages.REFRESHADMINUSERPAGEERROR);

	}

}
