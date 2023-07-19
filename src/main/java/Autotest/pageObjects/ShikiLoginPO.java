package Autotest.pageObjects;

import Autotest.utils.GlobalVariables;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShikiLoginPO extends BasePageObject {
    private @FindBy(id="user_nickname")
    WebElement usernameTextField;

    private @FindBy(id = "user_password")
    WebElement passwordTextField;

    private @FindBy(className = "btn-submit")
    WebElement loginButton;

    private @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBoxButton;

    public ShikiLoginPO() {
        super();
    }

    public void navigateToLoginPage () {
        navigateToURL(GlobalVariables.SHIKI_SITE_HOME_PAGE_URL + "/users/sign_in");
    }

    public void setUsernameTextField (String username) {
        sendKeys(usernameTextField, username);
    }

    public void setPasswordTextField (String password) {
        sendKeys(passwordTextField, password);
    }

    public void clickLogInButton() {
        waitForWebElementAndClick(loginButton);
    }

    public void validateSuccessLoginMessage() {
        getTextFromAlert("validation succeeded");
    }

    public void validateUnSuccessLoginMessage() {
        getTextFromAlert("validation failed");
    }

    public void clickCheckBoxButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForWebElementAndClick(checkBoxButton);
    }
}
