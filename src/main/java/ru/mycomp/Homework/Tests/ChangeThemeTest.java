package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.SettingPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class ChangeThemeTest extends BaseTest {
    SettingPage settingPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage();
        NewsPage newsPage = loginPage.authorize(login, password);
        UserPage userPage = newsPage.openUserPage();
        settingPage = userPage.openSettings();
    }

    @Test
    public void changeTheme() {
        settingPage.setDarkTheme();
        assertTrue(settingPage.checkDarkTheme());
    }

    @AfterEach
    public void tearDown() {
        settingPage.setLightTheme();
        logOut();
    }
}
