package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// PageFactory is a class .initElements() is a method to initialize
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeCheckbox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']")
	private WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	private WebElement title;
	

	public void enterUsernameOnUsernameField(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnCheckbox() {
		rememberMeCheckbox.click();

	}

	public void clickOnSignInButton() {
		signInButton.click();
	}
	public boolean isDashBoardDisplayed() {
		return dashBoard.isDisplayed();
	}
	public boolean isTitleDisplayed() {
		return title.isDisplayed();
	}

}
