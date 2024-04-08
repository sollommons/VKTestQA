package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mycomp.Homework.Core.Pages.FriendPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.SearchPage;


public class AddFriendTest extends BaseTest {
    private NewsPage newsPage;
    private FriendPage friendPage;

    @BeforeEach
    public void setup(){
        newsPage = authorize();
    }

    @ParameterizedTest(name = "{index} - {0} was added")
    @ValueSource(strings = {"technopol66"})
    @Tag("friends")
    public void addFriends(String userName) {
        newsPage.set(userName);
        SearchPage searchPage= newsPage.search();
        friendPage = searchPage.openFriendPage();
        friendPage.addFriend();
        Assertions.assertEquals("Запрос отправлен", friendPage.checkFriend());
    }

    @AfterEach
    public void tearDown()
    {
        friendPage.cancelApplication();
    }
}
