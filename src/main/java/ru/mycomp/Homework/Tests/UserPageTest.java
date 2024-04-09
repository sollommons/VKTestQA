package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class UserPageTest extends BaseTest{
    private UserPage userPage;

    @BeforeEach
    public void setup(){
        NewsPage newsPage = authorize();
        userPage = newsPage.openUserPage();
    }

    @Test
    @Tag("user")
    @DisplayName("Copy user's URL")
    public void copyUserURL() {
        String userURl="";
        try {
           userURl = userPage.copyUrl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("https://ok.ru/profile/586489906527?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована неправильно");
    }

}