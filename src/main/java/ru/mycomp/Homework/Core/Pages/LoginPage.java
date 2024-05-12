package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.Selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements LoadablePage{

    private By loginField = byXpath("//input[@id='field_email']");
    private By passwordField = byXpath("//input[@id='field_password']");
    private By loginButton = byXpath("//*[@value='Войти в Одноклассники']");

    public LoginPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        $(loginField).shouldBe(visible.because("Login field should be visible on login page"));
        $(passwordField).shouldBe(visible.because("Password field should be visible on login page"));
        $(loginButton).shouldBe(visible.because("Login button should be visible on login page"));
        return true;
    }

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage setLogin(String login) {
        $(loginField).shouldBe(visible.because("Login field should be visible for users to set login")).setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(passwordField).shouldBe(visible.because("Password field should be visible for users to set password")).setValue(password);
        return this;
    }

    public NewsPage login() {
        $(loginButton).shouldBe(visible.because("Login button should be visible to enter")).click();
        return new NewsPage();
    }

    public NewsPage authorize(String login, String password) {
        setLogin(login);
        setPassword(password);
        return login();
    }
}
