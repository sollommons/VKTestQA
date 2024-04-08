package ru.mycomp.Homework2.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework2.Core.Pages.NewsPage;
import ru.mycomp.Homework2.Core.Pages.UserPage;

import static com.codeborne.selenide.Selenide.sleep;
import static ru.mycomp.Homework2.Core.Pages.BasePage.userButton;


public class PublicationTest extends BaseTest{


    private UserPage userPage;
    private NewsPage newsPage;

    @BeforeEach
    public void setup(){
        newsPage = authorize();
    }

    @Test
    @Tag("user")
    public void publicateSmth()
    {
        userPage = newsPage.openUserPage();
        userPage.chooseToPublicate();
        userPage.publicate();
        String textOfPublication = userPage.checkPublication();
        Assertions.assertEquals("Приветственная публикация", textOfPublication);
    }

    @AfterEach
    public void tearDown() {
       userPage.deletePublication();
    }

}
