package ru.mycomp.Homework2.Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement loginField = $x("//input[@id='field_email']");
    private SelenideElement passwordField = $x("//input[@id='field_password']");
    private SelenideElement loginButton = $x("//input[@type='submit']");

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }


    public void setInfo(String login, String password){
        loginField.setValue(login);
        passwordField.setValue(password);
    }

    public NewsPage login()
    {
        loginButton.click();
        return new NewsPage();
    }
}
