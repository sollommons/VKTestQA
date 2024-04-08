package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;


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
