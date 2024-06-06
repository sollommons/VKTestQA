package ru.mycomp.Homework.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.mycomp.Homework.Core.Objects.TestBot;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTest {
    protected static final TestBot TEST_BOT = new TestBot("technopol60", "technopolisPassword");
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
