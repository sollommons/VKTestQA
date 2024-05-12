package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FriendPage extends BasePage {

    private static final By addFriendButton = byXpath("//a[@aria-label='Добавить в друзья']");
    private static final By applicationButton = byXpath("//button[@aria-label='Запрос отправлен']");
    private static final By cancelApplicationButton = byXpath("//a[@aria-label='Отменить запрос']");
    private static final By writeMessageButton = byXpath("//*[@data-l='outlandertarget,sendMessage,t,sendMessage']");
    private static final By settingOfSubscribingButton = byXpath("//button[@aria-label='Настроить подписку на профиль']");
    private static final By importantInfoButton = byXpath("//*[@data-l='t,filter']/a[2]");

    public FriendPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        super.checkPage();
        $(writeMessageButton).shouldBe(visible.because("Message button should be on friend page"));
        $(settingOfSubscribingButton).shouldBe(visible.because("Settings of Subscribing button should be on friend page"));
        $(importantInfoButton).shouldBe(visible.because("Important info button should be on friend page"));
        return true;
    }

    public FriendPage addFriend() {
        $(addFriendButton).shouldBe(visible.because("Add friend button should be to add friend")).click();
        return this;
    }

    public String checkFriend() {
        return $(applicationButton).text();
    }

    public void cancelApplication() {
        $(applicationButton).shouldBe(visible.because("Application button should be visible to see if request exists")).click();
        $(cancelApplicationButton).shouldBe(visible.because("Cancel application button should appear to cancel request")).click();
    }
}
