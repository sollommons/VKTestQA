package ru.mycomp.Homework2.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingPage {

    private SelenideElement changeThemeButton = $(byXpath("//a[@data-l='t,set_theme']"));
    private SelenideElement darkThemeButton = $(byXpath("//*[@data-theme='dark']/span"));
    private SelenideElement lightThemeButton = $(byXpath("//*[@data-theme='light']/span"));
    public SettingPage() {
        checkpage();
    }

    private void checkpage(){

    }

    public void setDarkTheme() {
        changeThemeButton.shouldBe(visible).click();
        darkThemeButton.shouldBe(visible).click();
    }

    public boolean checkDarkTheme(){
        return ($(byText("Тёмная")).exists());
    }
    public void setLightTheme() {
        changeThemeButton.shouldBe(visible).click();
        lightThemeButton.shouldBe(visible).click();
    }
}
