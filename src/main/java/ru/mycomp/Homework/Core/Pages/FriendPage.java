package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class FriendPage extends BasePage{
    private SelenideElement addFriendButton = $(byXpath("//a[@aria-label='Добавить в друзья']"));
    private SelenideElement applicationButton = $(byXpath("//button[@aria-label='Запрос отправлен']"));
    private SelenideElement cancelApplicationButton = $(byXpath("//a[@aria-label='Отменить запрос']"));
    private SelenideElement writeMessageButton = $(byXpath("//*[@data-l='outlandertarget,sendMessage,t,sendMessage']"));
    private SelenideElement settingOfSubscribingButton = $(byXpath("//button[@aria-label='Настроить подписку на профиль']"));
    private SelenideElement importantInfoButton = $(byXpath("//a[@id='tab-304']"));
    public FriendPage() {
        checkPage();
    }

    private void checkPage()
    {
        writeMessageButton.shouldBe(visible);
        settingOfSubscribingButton.shouldBe(visible);
        importantInfoButton.shouldBe(visible);
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
