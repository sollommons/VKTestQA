package ru.mycomp.Homework.Tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mycomp.Homework.Core.Pages.FriendPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class AddFriendTest extends BaseTest {
    private NewsPage newsPage;
    private FriendPage friendPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage();
        newsPage = loginPage.authorize(TEST_BOT.login(), TEST_BOT.password());
    }

    @ParameterizedTest(name = "{index} - {0} was added")
    @ValueSource(strings = {"technopol66", "technopol44"})
    @Tag("friends")
    public void addFriends(String userName) {
        newsPage.set(userName);
        friendPage = newsPage.search()
                .openFriendPage()
                .addFriend();
        Assertions.assertEquals("Запрос отправлен", friendPage.checkFriend());
    }

    @AfterEach
    public void tearDown() {
        friendPage.cancelApplication();
        logOut();
    }
}
