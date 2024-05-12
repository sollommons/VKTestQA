package ru.mycomp.Homework.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mycomp.Homework.Core.Objects.TestBotsDataProvider;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class LoginTest {

    @BeforeMethod
    public void setupConf() {
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://ok.ru/";
        Selenide.open("/");
    }

    @Test(dataProvider = "testBotsData", dataProviderClass = TestBotsDataProvider.class)
    public void loginToOK(String login, String password) {
        NewsPage newsPage = new LoginPage()
                .setLogin(login)
                .setPassword(password)
                .login();
        Assertions.assertTrue(newsPage.checkMoment(), "Открылась не та страница");
    }

    @AfterMethod
    public void tearDown() {
        logOut();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
