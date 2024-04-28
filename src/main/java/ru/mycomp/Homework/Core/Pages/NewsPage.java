package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends BasePage {

    private By searchField = byXpath("//input[@name='st.query']");
    private By momentsButton = byXpath("//button[@data-l='t,to_moments']");
    private By upperHobbyButton = byXpath("//button[@data-l='t,to_hobbies']");
    private By blockFriendsStream = byXpath("//div[@data-sticky-id='friendsStream']");

    public NewsPage() {
        checkPage();
    }

    @Override
    protected void checkPage() {
        super.checkPage();
        $(momentsButton).shouldBe(visible.because("Moments should be visible news page"));
        $(upperHobbyButton).shouldBe(visible.because("Hobby button should be visible news page"));
        $(blockFriendsStream).shouldBe(visible.because("Friends stream should be visible news page"));
    }

    public void set(String name) {
        $(searchField).shouldBe(visible.because("Search field should be visible to enter name")).setValue(name);
        $(searchField).shouldHave(value(name));
    }

    public SearchPage search() {
        $(searchField).shouldBe(visible.because("Search field should be visible to search")).click();
        $(searchField).pressEnter();
        return new SearchPage();
    }

    public UserPage openUserPage() {
        $(userButton).shouldBe(visible.because("User button should be visible to click")).click();
        return new UserPage();
    }

    public boolean checkMoment() {
        return ($(byText("Моменты")).exists());
    }
}
