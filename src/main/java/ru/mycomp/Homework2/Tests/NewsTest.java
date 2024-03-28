package ru.mycomp.Homework2.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework2.BrowserConfig;
import ru.mycomp.Homework2.Pages.LoginPage;
import ru.mycomp.Homework2.Pages.NewsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewsTest {

    BrowserConfig browserConfig = new BrowserConfig();
    NewsPage newsPage;


    @BeforeEach
    public void setup(){
        browserConfig.setupConf();
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.setInfo("technopol60", "technopolisPassword");
        newsPage = loginPage.login();
    }

    @Test
    public void publicateSmth()
    {
        newsPage.chooseToPublicate();
        $(byText("Заметка, рассказ любой длины")).shouldBe(visible);
    }
    @Test
    public void okFriends() {
        newsPage.set("technopol66");
        newsPage.search();
        $(byText("technopol66 technopol66")).shouldBe(visible);
    }

    @AfterEach
    public void end(){
        browserConfig.endJob();
    }
}
