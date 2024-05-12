package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;
import ru.mycomp.Homework.Core.Elements.NavigationBlockElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends BasePage {

    private static final By searchField = byXpath("//input[@name='st.query']");
    private static final By momentsButton = byXpath("//button[@data-l='t,to_moments']");
    private static final By upperHobbyButton = byXpath("//button[@data-l='t,to_hobbies']");
    private static final By blockFriendsStream = byXpath("//div[@data-sticky-id='friendsStream']");

    private final NavigationBlockElement navBlock = new NavigationBlockElement();

    public NewsPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        super.checkPage();
        $(momentsButton).shouldBe(visible.because("Moments should be visible news page"));
        $(upperHobbyButton).shouldBe(visible.because("Hobby button should be visible news page"));
        $(blockFriendsStream).shouldBe(visible.because("Friends stream should be visible news page"));
        return true;
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
        return navBlock.openUserPage();
    }

    public boolean checkMoment() {
        return ($(byText("Моменты")).exists());
    }
}
