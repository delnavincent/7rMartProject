package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement adminField;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logOutField;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement SignInButton;

	public void clickOnAdminField() {
		adminField.click();

	}

	public void clickOnLogOutField() {
		logOutField.click();
	}
	public boolean isSignInButtonEnabled() {
		return SignInButton.isEnabled();
	}

}
