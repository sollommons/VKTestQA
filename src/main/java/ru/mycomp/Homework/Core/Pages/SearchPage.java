package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private By friendProfileButton = byXpath("//*[@id='tabpanel-users']/div[2]/div[1]/div/div/a");
    private By upperPeopleButton = byXpath("//button[@id='tab-users']");
    private By upperPublicationsButton = byXpath("//button[@id='tab-publications']");
    private By upperGroupsButton = byXpath("//button[@id='tab-groups']");

    public SearchPage() {
        checkPage();
    }

    @Override
    protected void checkPage() {
        super.checkPage();
        $(upperPeopleButton).shouldBe(visible.because("People button should be visible search page"));
        $(upperPublicationsButton).shouldBe(visible.because("Publication button should be visible search page"));
        $(upperGroupsButton).shouldBe(visible.because("Groups button should be visible search page"));
    }

    public FriendPage openFriendPage() {
        $(friendProfileButton).shouldBe(visible.because("Friend profile button should be visible to open")).click();
        return new FriendPage();
    }
}
