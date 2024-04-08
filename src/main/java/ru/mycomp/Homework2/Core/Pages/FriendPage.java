package ru.mycomp.Homework2.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class FriendPage extends BasePage{
    private SelenideElement addFriendButton = $(byXpath("//a[@aria-label='Добавить в друзья']"));
    private SelenideElement applicationButton = $(byXpath("//button[@aria-label='Запрос отправлен']"));
    private SelenideElement cancelApplicationButton = $(byXpath("//a[@aria-label='Отменить запрос']"));

    public FriendPage() {
        checkPage();
    }

    private void checkPage()
    {

    }
    public void addFriend() {
        addFriendButton.shouldBe(visible).click();
    }

    public String checkFriend(){
        return applicationButton.text();
    }
    public void cancelApplication(){
        applicationButton.shouldBe(visible).click();
        cancelApplicationButton.shouldBe(visible).click();
    }

}
