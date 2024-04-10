package ru.mycomp.Homework.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class BaseTest {
    private static final String login = "technopol60";
    private static final String password = "technopolisPassword";

    @BeforeAll
    public static void setupConf() {
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://ok.ru/";
        Selenide.open("/");
    }

    public static NewsPage authorize() {
        LoginPage loginPage = new LoginPage();
        loginPage.setInfo(login, password);
        return loginPage.login();
    }

    @AfterEach
    public void endJob() {
        logOut();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
