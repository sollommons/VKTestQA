package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public static SelenideElement userButton =  $(byXpath("//*[@data-l='t,userPage']"));
    public static SelenideElement newsButton =  $(byXpath("//*[@data-l='t,userMain']"));
    public static SelenideElement hobbyButton =  $(byXpath("//*[@data-l='t,hobby']"));
    public static SelenideElement friendsButton =  $(byXpath("//*[@data-l='t,userFriend']"));
    public static SelenideElement photoButton =  $(byXpath("//*[@data-l='t,userPhotos']"));
    public static SelenideElement groupsButton =  $(byXpath("//*[@data-l='t,userAltGroup']"));
    public static SelenideElement gamesButton =  $(byXpath("//*[@data-l='t,appShowcaseHD']"));
    public static SelenideElement giftsButton =  $(byXpath("//*[@data-l='t,giftsFront']"));
    public static SelenideElement recomendationButton =  $(byXpath("//*[@data-l='t,discovery']"));
    public static SelenideElement appsButton =  $(byXpath("//*[@data-l='t,bizApps']"));
    public static SelenideElement datingButton =  $(byXpath("//*[@data-l='t,appsDating']"));

    public static SelenideElement miniUserToolbar =$(byXpath("//button[@aria-label='Настройки профиля']"));
    public static SelenideElement exitButton = $(byXpath("//a[@data-l='t,logout']"));
    public static SelenideElement confirmationOfExitButton = $(byXpath("//input[@data-l='t,logout']"));

    public static void logOut() {
        miniUserToolbar.shouldBe(visible).click();
        exitButton.shouldBe(visible).click();
        confirmationOfExitButton.shouldBe(visible).click();
    }
}
