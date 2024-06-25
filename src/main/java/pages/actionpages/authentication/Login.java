package pages.actionpages.authentication;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageActionsBase;
import pages.uipages.authentication.LoginPageUI;
import utils.readers.Config;
import utils.webdrivers.DriverManager;

/**
 * This class contains only login page related actions method
 * 
 * @author Mahendra
 */
public class Login extends PageActionsBase {

	
	public Login(DriverManager driverManager) {
		super(driverManager, new LoginPageUI());
		browserActions.load(Config.getAccessBaseURL());
	}

	/**
	 * Method is used to login the page and accessible by outside classes
	 * 
	 * @param userName
	 * @param password
	 */
	public void fillUpCredintials(String userName, String password) {
		logManager.logInformation("Trying to login: ", true, true);
		addUserNameDetails(userName);
		addPasswordDetails(password);
		clickOnLoginButton();
	}

	/**
	 * Method is used to add userName in UserName Text-field
	 * 
	 * @param accessCode
	 */
/*
	private void addAccessCodeDetails(String accessCode) {
		String accessCodeTextField = "accessCode";
		WebElement accessCodeTextFieldElement = pageObject.getTextField(accessCodeTextField);

		if (browserActions.waitForElementVisible(accessCodeTextFieldElement, largestPageTimeout, accessCodeTextField)
				&& !accessCode.isBlank()) {
			browserActions.addDataInTheTextField(accessCodeTextFieldElement, accessCode, accessCodeTextField);
		} else {
			Assert.fail("Access code is blank");
		}
	}
*/
	/**
	 * Method is used to add userName in UserName Text-field
	 * 
	 * @param userName
	 */
	private void addUserNameDetails(String userName) {
		String userNameTextField = "userName";
		WebElement userNameTextFieldElement = pageObject.getTextField(userNameTextField);

		if (browserActions.waitForElementVisible(userNameTextFieldElement, smallPageTimeout, userNameTextField)) {
			browserActions.addDataInTheTextField(userNameTextFieldElement, userName, userNameTextField);
		}
	}

	/**
	 * Method is used to add password in Password Text-field
	 * 
	 * @param password
	 */
	private void addPasswordDetails(String password) {
		String passwordTextField = "password";
		WebElement passwordTextFieldElement = pageObject.getTextField(passwordTextField);

		if (browserActions.waitForElementVisible(passwordTextFieldElement, smallPageTimeout, passwordTextField)) {
			browserActions.addDataInTheTextField(passwordTextFieldElement, password, passwordTextField);
		}
	}

	/**
	 * Method is used to Click on Login Button
	 */
	private void clickOnLoginButton() {
		String signInButton = "signIn";
		WebElement signInButtonElement = pageObject.getButton(signInButton);

		if (browserActions.waitForElementClickable(signInButtonElement, smallPageTimeout, signInButton)) {
			browserActions.clickButton(signInButtonElement, signInButton);
		}
	}

}
