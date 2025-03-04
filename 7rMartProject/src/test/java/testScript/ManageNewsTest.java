package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(priority = 1, description = "verification of user can enter news in ManageNews by clicking New button")
	public void verifyWhetherUserCanEnterNewNewsInformationsInManageNewsField() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnManageNewsField();
		manageNews.clickOnNewField();
		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		manageNews.enterTheNewsOnNewsField(news);
		manageNews.clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = manageNews.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, "user was unable to create new news!");

	}

	@Test(priority = 2, description = "verification of user can search news in ManageNews by clicking Search button ")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNewsInManageNewsField() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnManageNewsField();
		manageNews.clickOnSearchField();
		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		manageNews.enterTheNewsToSearch(news);
		manageNews.clickOnSearchButton();

		boolean isSubTitleOfSearchManageNewsDisplayed = manageNews.isSubTitleOfSearchManageNewsPageDisplayed();
		Assert.assertTrue(isSubTitleOfSearchManageNewsDisplayed, "user is unable to search news");

	}

	@Test(priority = 3, description = "verification of user can refresh ManageNews page by clicking Reset  button")
	public void verifyWhetherUserIsAbleToRefreshManageNewsPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnManageNewsField();
		manageNews.clickOnResetButton();

		boolean isTitleOfManageNewsResetPageDisplayed = manageNews.isTitleOfManageNewsResetPageDisplayed();
		Assert.assertTrue(isTitleOfManageNewsResetPageDisplayed, "user is unable to refresh the manage news page");

	}

}
