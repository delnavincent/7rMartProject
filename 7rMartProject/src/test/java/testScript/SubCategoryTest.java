package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	@Test(priority = 1, description = "verification of user can enter new subcategory informations to SubCategory list by clicking New button")
	public void verifyWhetherUserIsAbleToAddNewSubCategoryItemsToSubCategoryList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategoryField();
		subCategory.clickOnNewField();
		subCategory.selectCategoryFromCategoryField();
		String subcategoryText = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		subCategory.enterSubCategoryTextOnSubCategoryfield(subcategoryText);
		subCategory.chooseFileOnImageField();
		subCategory.clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = subCategory.getTextFromSubcategoryAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.ADDNEWITEMTOSUBCATEGORYERROR);

	}

	@Test(priority = 2, description = "verification of user can search subcategory details from SubCategory list by clicking Search button")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedSubCategoryItemsFromSubCategoryList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategoryField();
		subCategory.clickOnSearchField();
		subCategory.selectCategoryToSearch();
		String subcategoryData = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		subCategory.enterSubCategoryTextToSearch(subcategoryData);
		subCategory.clickOnSearchButton();

		boolean isSubTitleDisplayed = subCategory.isSubTitleDisplayedOnSearchSubCategoryPage();
		Assert.assertTrue(isSubTitleDisplayed, Messages.SEARCHITEMINSUBCATEGORYERROR);

	}

	@Test(priority = 3, description = "verification of user can refresh subcategory page by clicking reset button")
	public void verifyWhetherUserIsAbleToRefreshSubCategoryPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		SubCategoryPage subCategory = new SubCategoryPage(driver);
		subCategory.clickOnSubCategoryField();
		subCategory.clickOnResetButton();

		boolean isTitleDisplayedOnResetPage = subCategory.isTitleDisplayedOnResetPage();
		Assert.assertTrue(isTitleDisplayedOnResetPage, Messages.REFRESHSUBCATEGORYPAGEERROR);

	}

}
