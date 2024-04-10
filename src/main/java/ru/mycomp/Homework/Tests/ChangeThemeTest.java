package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.SettingPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangeThemeTest extends BaseTest {
    SettingPage settingPage;

    @BeforeEach
    public void setup() {
        NewsPage newsPage = authorize();
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
    }
}
