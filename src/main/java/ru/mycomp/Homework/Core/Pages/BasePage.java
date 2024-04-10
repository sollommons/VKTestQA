package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static By userButton = byXpath("//*[@data-l='t,userPage']");
    public static By newsButton = byXpath("//*[@data-l='t,userMain']");
    public static By hobbyButton = byXpath("//*[@data-l='t,hobby']");
    public static By friendsButton = byXpath("//*[@data-l='t,userFriend']");
    public static By photoButton = byXpath("//*[@data-l='t,userPhotos']");
    public static By groupsButton = byXpath("//*[@data-l='t,userAltGroup']");
    public static By gamesButton = byXpath("//*[@data-l='t,appShowcaseHD']");
    public static By giftsButton = byXpath("//*[@data-l='t,giftsFront']");
    public static By recomendationButton = byXpath("//*[@data-l='t,discovery']");
    public static By appsButton = byXpath("//*[@data-l='t,bizApps']");
    public static By datingButton = byXpath("//*[@data-l='t,appsDating']");
    public static By miniUserToolbar = byXpath("//button[@aria-label='Настройки профиля']");
    public static By exitButton = byXpath("//a[@data-l='t,logout']");
    public static By confirmationOfExitButton = byXpath("//input[@data-l='t,logout']");

    public static void logOut() {
        $(miniUserToolbar).shouldBe(visible.because("Mini toolbar should be on every page")).click();
        $(exitButton).shouldBe(visible.because("Exit button should be on every page")).click();
        $(confirmationOfExitButton).shouldBe(enabled.because("Confirmation of exit button should be enabled to exit")).click();
    }
}
