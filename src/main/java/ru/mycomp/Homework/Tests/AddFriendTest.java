package ru.mycomp.Homework.Tests;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mycomp.Homework.Core.Pages.FriendPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.SearchPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class AddFriendTest extends BaseTest {
    private NewsPage newsPage;
    private FriendPage friendPage;

    @BeforeEach
    public void setup() {
        Selenide.open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        newsPage = loginPage.login();
    }

    @ParameterizedTest(name = "{index} - {0} was added")
    @ValueSource(strings = {"technopol66", "technopol44"})
    @Tag("friends")
    public void addFriends(String userName) {
        newsPage.set(userName);
        SearchPage searchPage = newsPage.search();
        friendPage = searchPage.openFriendPage();
        friendPage.addFriend();
        Assertions.assertEquals("Запрос отправлен", friendPage.checkFriend());
    }

    @AfterEach
    public void tearDown() {
        friendPage.cancelApplication();
        logOut();
    }
}
