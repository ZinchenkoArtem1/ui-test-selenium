package ua.com.zinchenko.seleniumuitest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    @FindBy(css = "input#username.w100.inputform-field")
    private WebElement usernameInputField;

    @FindBy(css = "input#password.w100.inputform-field")
    private WebElement passwordInputField;

    @FindBy(css = "button.button-large.button-solid-norm.w100.mt1-75")
    private WebElement submitButton;

    @FindBy(css = "div.p1.mb0.text-break.notification.notification--in.notification-danger")
    private WebElement incorrectLoginCredentialsNotification;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        usernameInputField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public InboxPage successSubmit() {
        submitButton.click();
        return new InboxPage(driver);
    }

    public String getNotificationAboutIncorrectCredentials() {
        return incorrectLoginCredentialsNotification.getAttribute("innerHTML");
    }
}
