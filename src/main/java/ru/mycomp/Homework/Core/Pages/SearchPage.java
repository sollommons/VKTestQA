package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private static final By friendProfileButton = byXpath("//*[contains(@data-l, '\"position\":0')and contains(@data-l,'\"target\":\"NAME\"')]");
    private static final By upperPeopleButton = byXpath("//button[@id='tab-users']");
    private static final By upperPublicationsButton = byXpath("//button[@id='tab-publications']");
    private static final By upperGroupsButton = byXpath("//button[@id='tab-groups']");

    public SearchPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        super.checkPage();
        $(upperPeopleButton).shouldBe(visible.because("People button should be visible search page"));
        $(upperPublicationsButton).shouldBe(visible.because("Publication button should be visible search page"));
        $(upperGroupsButton).shouldBe(visible.because("Groups button should be visible search page"));
        return true;
    }

    public FriendPage openFriendPage() {
        $(friendProfileButton).shouldBe(visible.because("Friend profile button should be visible to open")).click();
        return new FriendPage();
    }
}
