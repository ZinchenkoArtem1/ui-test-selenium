package ua.com.zinchenko.seleniumuitest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends PageObject {

    @FindBy(css = "span.inline-block.max-w100.text-ellipsis.align-bottom")
    private WebElement usernameWelcomeTitle;

    @FindBy(css = "button.button.button-large.button-solid-norm.text-bold.mt0-25.w100.no-mobile")
    private WebElement newMessageWindow;

    @FindBy(css = "span.flex-item-fluid.p0-5.pr1.pl0-75.text-ellipsis.user-select-none.cursor-move")
    private WebElement titleInMessageWindow;

    @FindBy(id = "global_search")
    private WebElement searchMessagesField;

    @FindBy(css = "button.button.button-for-icon.button-ghost-weak.searchbox-search-button.flex")
    private WebElement searchButton;

    @FindBy(css = "figcaption.mt2 h3.text-bold")
    private WebElement failedSearchResult;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public String getUsernameWelcomeTitle() {
        return usernameWelcomeTitle.getText();
    }

    public void openNewMessageWindowOpen() {
        newMessageWindow.click();
    }

    public String getTextFromTitleInMessageWindow() {
        return titleInMessageWindow.getText();
    }

    public void inputSearch(String query) {
        searchMessagesField.sendKeys(query);
    }

    public void search() {
        searchButton.click();
    }

    public String getFailedSearchResult() {
        return failedSearchResult.getText();
    }
}

