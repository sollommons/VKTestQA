package ru.mycomp.Homework2.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework2.BrowserConfig;
import ru.mycomp.Homework2.Pages.LoginPage;
import ru.mycomp.Homework2.Pages.MainPage;
import ru.mycomp.Homework2.Pages.NewsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPageTest {
    BrowserConfig browserConfig = new BrowserConfig();
    MainPage mainPage;



    @BeforeEach
    public void setup(){
        browserConfig.setupConf();
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.setInfo("technopol60", "technopolisPassword");
        NewsPage newsPage = loginPage.login();
        mainPage = newsPage.goToMainPage();
    }

    @Test
    public void okUserInfo() {
        mainPage.copyUrl();
        $(byText("Копировать ссылку")).shouldBe(visible);
    }

    @AfterEach
    public void end(){
        browserConfig.endJob();
    }
}
