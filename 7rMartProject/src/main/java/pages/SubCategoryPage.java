package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class=' nav-link']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newfield;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectCategoryField;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryText;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchfield;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement selectField;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchSubCategorytext;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement addSubcatecoryAlert;
	@FindBy(xpath = "//h4[text()='Search List Sub Categories']")
	private WebElement subTitle;
	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement titleOfResetPage;

	public void clickOnSubCategoryField() {
		subCategoryField.click();

	}

	public void clickOnNewField() {
		newfield.click();

	}

	public void selectCategoryFromCategoryField() {
		Select select = new Select(selectCategoryField);
		select.selectByIndex(4);
	}

	public void enterSubCategoryTextOnSubCategoryfield(String subcategoryText) {
		subCategoryText.sendKeys(subcategoryText);

	}

	public void chooseFileOnImageField() {
		imageUpload.sendKeys(Constants.IMAGEFILE);

	}

	public void clickOnSaveButton() {
		saveButton.submit();
	}

	public void clickOnSearchField() {
		searchfield.click();
	}

	public void selectCategoryToSearch() {
		Select select = new Select(selectField);
		select.selectByIndex(5);

	}

	public void enterSubCategoryTextToSearch(String subcategoryData) {

		searchSubCategorytext.sendKeys(subcategoryData);

	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnResetButton() {
		resetButton.click();

	}

	public String getTextFromSubcategoryAlert() {
		return addSubcatecoryAlert.getText();
	}

	public boolean isSubTitleDisplayedOnSearchSubCategoryPage() {
		return subTitle.isDisplayed();
	}

	public boolean isTitleDisplayedOnResetPage() {
		return titleOfResetPage.isDisplayed();
	}

}
