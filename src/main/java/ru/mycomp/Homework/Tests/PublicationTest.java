package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class PublicationTest extends BaseTest {
    private UserPage userPage;
    private NewsPage newsPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage();
        newsPage = loginPage.authorize(login, password);
    }

    @Test
    @Tag("user")
    public void publicateSmth() {
        userPage = newsPage.openUserPage();
        userPage.chooseToPublicate();
        userPage.publicate();
        String textOfPublication = userPage.checkPublication();
        Assertions.assertEquals("Приветственная публикация", textOfPublication);
    }

    @AfterEach
    public void tearDown() {
        userPage.deletePublication();
        logOut();
    }

}
