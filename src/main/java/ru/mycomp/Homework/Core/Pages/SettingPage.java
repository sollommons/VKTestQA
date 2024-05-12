package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingPage implements LoadablePage{

    private By changeThemeButton = byXpath("//a[@data-l='t,set_theme']");
    private By darkThemeButton = byXpath("//*[@data-theme='dark']/span");
    private By lightThemeButton = byXpath("//*[@data-theme='light']/span");
    private By personalInfoSettingButton = byXpath("//a[@data-l='t,personal_info']");
    private By privacySettingButton = byXpath("//a[@data-l='t,privacy']");
    private By profileSettingButton = byXpath("//a[@data-l='t,profile_options']");

    public SettingPage() {
        checkPage();
    }
    @Override
    public boolean checkPage() {
        $(personalInfoSettingButton).shouldBe(visible.because("Personal info settings button should be visible settings page"));
        $(privacySettingButton).shouldBe(visible.because("Privacy settings button should be visible settings page"));
        $(profileSettingButton).shouldBe(visible.because("Profile settings button should be visible settings page"));
        return true;
    }

    public void setDarkTheme() {
        $(changeThemeButton).shouldBe(enabled.because("Change theme button should be enabled to change theme")).click();
        $(darkThemeButton).shouldBe(visible.because("Dark theme button should be visible to choose")).click();
        $(changeThemeButton).shouldBe(enabled.because("Change theme button should be enabled to change theme")).click();
    }

    public boolean checkDarkTheme() {
        return ($(byText("Тёмная")).exists());
    }

    public void setLightTheme() {
        $(changeThemeButton).shouldBe(enabled.because("Change theme button should be enabled to change theme")).click();
        $(lightThemeButton).shouldBe(visible.because("Light theme button should be visible to choose")).click();
        $(changeThemeButton).shouldBe(enabled.because("Change theme button should be enabled to change theme")).click();
    }
}
