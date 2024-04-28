package ru.mycomp.Homework.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    protected static final String login = "technopol60";
    protected static final String password = "technopolisPassword";

    @BeforeEach
    public void setupConf() {
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://ok.ru/";
        Selenide.open("/");
    }

    @AfterEach
    public void endJob() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
