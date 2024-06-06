package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage implements LoadablePage {

    public static final By miniUserToolbar = byXpath("//button[@aria-label='Настройки профиля']");
    public static final By exitButton = byXpath("//a[@data-l='t,logout']");
    public static final By confirmationOfExitButton = byXpath("//input[@data-l='t,logout']");

    public static void logOut() {
        $(miniUserToolbar).shouldBe(visible.because("Mini toolbar should be on every page")).click();
        $(exitButton).shouldBe(visible.because("Exit button should be on every page")).click();
        $(confirmationOfExitButton).shouldBe(enabled.because("Confirmation of exit button should be enabled to exit")).click();
    }

    @Override
    public boolean checkPage() {
        $(miniUserToolbar).shouldBe(visible.because("Mini toolbar should be on every page"));
        return true;
    }
}
