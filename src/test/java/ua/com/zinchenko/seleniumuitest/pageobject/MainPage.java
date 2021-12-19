package ua.com.zinchenko.seleniumuitest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(css = "a.btn.btn-ghost.btn-short")
    private WebElement getSignInPageButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage getSignInPage(){
        getSignInPageButton.click();
        return new SignInPage(driver);
    }

}
