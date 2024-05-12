package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class PublicationTest extends BaseTest {
    private NewsPage newsPage;

    @BeforeEach
    public void setup()
    {
        LoginPage loginPage = new LoginPage();
        newsPage = loginPage.authorize(TEST_BOT.login(), TEST_BOT.password());
    }

    @RepeatedTest(value = 3, name = "Test number {currentRepetition}/{totalRepetitions}")
    @Tag("user")
    public void publicateSmth() {
        String textOfPublication = newsPage.openUserPage()
                .chooseToPublicate()
                .publicate()
                .checkPublication();
        Assertions.assertEquals("Приветственная публикация", textOfPublication);
    }

    @AfterEach
    public void tearDown() {
        UserPage userPage = new UserPage();
        userPage.deletePublication();
        logOut();
    }

}
