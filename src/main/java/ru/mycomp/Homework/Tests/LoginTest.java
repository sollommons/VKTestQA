package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class LoginTest extends BaseTest {
    @Test
    public void loginToOK() {
        NewsPage newsPage = new LoginPage()
                .setLogin(login)
                .setPassword(password)
                .login();
        Assertions.assertTrue(newsPage.checkMoment(), "Открылась не та страница");
    }

    @AfterEach
    public void tearDown() {
        logOut();
    }
}
