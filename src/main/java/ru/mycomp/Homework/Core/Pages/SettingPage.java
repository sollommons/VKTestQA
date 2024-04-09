package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingPage {

    private SelenideElement changeThemeButton = $(byXpath("//a[@data-l='t,set_theme']"));
    private SelenideElement darkThemeButton = $(byXpath("//*[@data-theme='dark']/span"));
    private SelenideElement lightThemeButton = $(byXpath("//*[@data-theme='light']/span"));

    private SelenideElement personalInfoSettingButton = $(byXpath("//a[@data-l='t,personal_info']"));
    private SelenideElement privacySettingButton = $(byXpath("//a[@data-l='t,privacy']"));
    private SelenideElement profileSettingButton = $(byXpath("//a[@data-l='t,profile_options']"));
    public SettingPage() {
        checkpage();
    }

    private void checkpage(){
        personalInfoSettingButton.shouldBe(visible);
        privacySettingButton.shouldBe(visible);
        profileSettingButton.shouldBe(visible);
    }

    public void setDarkTheme() {
        changeThemeButton.shouldBe(enabled).click();
        darkThemeButton.shouldBe(visible).click();
        changeThemeButton.shouldBe(enabled).click();
    }

    public boolean checkDarkTheme(){
        return ($(byText("Тёмная")).exists());
    }
    public void setLightTheme() {
        changeThemeButton.shouldBe(enabled).click();
        lightThemeButton.shouldBe(visible).click();
        changeThemeButton.shouldBe(enabled).click();
    }
}
