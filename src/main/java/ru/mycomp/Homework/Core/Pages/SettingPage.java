package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SettingPage implements LoadablePage{

    private static final By appearanceButton = byXpath(".//*[@data-l='eueContainer,settings']/a[10]");
    private static final By changeThemeButton = byXpath(".//a[@data-l='t,set_theme']");
    private static final By darkThemeButton = byXpath(".//*[@data-theme='dark']/span");
    private static final By lightThemeButton = byXpath(".//*[@data-theme='light']/span");
    private static final By personalInfoSettingButton = byXpath(".//a[@data-l='t,profile_form']");
    private static final By safetySettingButton = byXpath(".//a[@data-l='t,privacy_option']");
    private static final By privacySettingButton = byXpath(".//a[@data-l='t,privacy']");

    public SettingPage() {
        checkPage();
    }
    @Override
    public boolean checkPage() {
        $(personalInfoSettingButton).shouldBe(visible.because("Personal info settings button should be visible settings page"));
        $(privacySettingButton).shouldBe(visible.because("Privacy settings button should be visible settings page"));
        $(safetySettingButton).shouldBe(visible.because("Profile settings button should be visible settings page"));
        return true;
    }

    public SettingPage openAppearanceSettings() {
        $(appearanceButton).shouldBe(visible.because("Appearance button should be visible to open")).click();
        return this;
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
