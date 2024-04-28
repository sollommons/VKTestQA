package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void loginToOK() {
        loginPage = new LoginPage();
        loginPage.open();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        NewsPage newsPage = loginPage.login();
        Assertions.assertTrue(newsPage.checkMoment(), "Открылась не та страница");
    }

    @AfterEach
    public void tearDown() {
        logOut();
    }
}
