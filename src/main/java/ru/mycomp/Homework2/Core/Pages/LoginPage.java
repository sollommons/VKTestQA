package ru.mycomp.Homework2.Core.Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage{
    private SelenideElement loginField = $(byXpath("//input[@id='field_email']"));
    private SelenideElement passwordField = $(byXpath("//input[@id='field_password']"));
    private SelenideElement loginButton = $(byXpath("//*[@value='Войти в Одноклассники']"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public void setInfo(String login, String password){
        loginField.shouldBe(visible).setValue(login);
        passwordField.shouldBe(visible).setValue(password);
    }

    public NewsPage login()
    {
        loginButton.shouldBe(visible).click();
        return new NewsPage();
    }
}
