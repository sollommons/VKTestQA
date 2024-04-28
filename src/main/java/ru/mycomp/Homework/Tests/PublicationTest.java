package ru.mycomp.Homework.Tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class PublicationTest extends BaseTest {
    private UserPage userPage;
    private NewsPage newsPage;

    @BeforeEach
    public void setup()
    {
        LoginPage loginPage = new LoginPage();
        newsPage = loginPage.authorize(login, password);
    }

    @RepeatedTest(value = 3, name = "Test number {currentRepetition}/{totalRepetitions}")
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
