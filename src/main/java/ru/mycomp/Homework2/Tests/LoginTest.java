package ru.mycomp.Homework2.Tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework2.Pages.NewsPage;
import ru.mycomp.Homework2.Pages.LoginPage;
import ru.mycomp.Homework2.BrowserConfig;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest {
    LoginPage loginPage = new LoginPage();
    BrowserConfig browserConfig = new BrowserConfig();


    @BeforeEach
    public void setup(){
        browserConfig.setupConf();
    }

    @Test
    public void okLogin() {
        loginPage.open();
        loginPage.setInfo("technopol60", "technopolisPassword");
        NewsPage newsPage = loginPage.login();
        $(byText("Рекомендация игры")).shouldBe(visible);
    }

     @AfterEach
    public void end(){
        browserConfig.endJob();
    }
}
