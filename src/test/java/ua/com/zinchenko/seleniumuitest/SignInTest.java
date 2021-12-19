package ua.com.zinchenko.seleniumuitest;

import org.junit.jupiter.api.Test;
import ua.com.zinchenko.seleniumuitest.pageobject.InboxPage;
import ua.com.zinchenko.seleniumuitest.pageobject.MainPage;
import ua.com.zinchenko.seleniumuitest.pageobject.SignInPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignInTest extends BaseFunctionalTest {

    @Test
    public void correctSignInTest() {
        driver.get(MAIN_PAGE_URL);

        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = mainPage.getSignInPage();

        signInPage.inputUsername(CORRECT_USERNAME);
        signInPage.inputPassword(CORRECT_PASSWORD);
        InboxPage inboxPage = signInPage.successSubmit();

        assertEquals(inboxPage.getUsernameWelcomeTitle().toLowerCase(), CORRECT_USERNAME);
    }
}
