package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;
import ru.mycomp.Homework.Core.Elements.NavigationBlockElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage implements NavigationBlockElement, LoadablePage {

    public static By miniUserToolbar = byXpath("//button[@aria-label='Настройки профиля']");
    public static By exitButton = byXpath("//a[@data-l='t,logout']");
    public static By confirmationOfExitButton = byXpath("//input[@data-l='t,logout']");

    public static void logOut() {
        $(miniUserToolbar).shouldBe(visible.because("Mini toolbar should be on every page")).click();
        $(exitButton).shouldBe(visible.because("Exit button should be on every page")).click();
        $(confirmationOfExitButton).shouldBe(enabled.because("Confirmation of exit button should be enabled to exit")).click();
    }

    @Override
    public boolean checkPage() {
        $(newsButton).shouldBe(visible.because("News button should be on every page"));
        $(friendsButton).shouldBe(visible.because("Friends of Subscribing button should be on every page"));
        $(groupsButton).shouldBe(visible.because("Groups info button should be on every page"));
        $(recomendationButton).shouldBe(visible.because("Recommendation button should be on every page"));
        $(photoButton).shouldBe(visible.because("Photo button should be on every page"));
        return true;
    }
}
