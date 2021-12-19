package ua.com.zinchenko.seleniumuitest;

import org.junit.jupiter.api.Test;
import ua.com.zinchenko.seleniumuitest.pageobject.InboxPage;
import ua.com.zinchenko.seleniumuitest.pageobject.MainPage;
import ua.com.zinchenko.seleniumuitest.pageobject.SignInPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InboxTest extends BaseFunctionalTest {

    @Test
    public void newMessageWindowOpenTest() {
        driver.get(MAIN_PAGE_URL);

        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = mainPage.getSignInPage();

        signInPage.inputUsername(CORRECT_USERNAME);
        signInPage.inputPassword(CORRECT_PASSWORD);
        InboxPage inboxPage = signInPage.successSubmit();

        inboxPage.openNewMessageWindowOpen();
        assertEquals(inboxPage.getTextFromTitleInMessageWindow(), "New message");
    }

    @Test
    public void notFoundMessages() {
        driver.get(MAIN_PAGE_URL);

        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = mainPage.getSignInPage();

        signInPage.inputUsername(CORRECT_USERNAME);
        signInPage.inputPassword(CORRECT_PASSWORD);
        InboxPage inboxPage = signInPage.successSubmit();

        inboxPage.inputSearch(NO_EXIST_SEARCH_QUERY);
        inboxPage.search();
        assertEquals(inboxPage.getFailedSearchResult(), "No results found");
    }
}
