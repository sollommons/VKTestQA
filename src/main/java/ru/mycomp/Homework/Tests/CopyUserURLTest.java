package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class CopyUserURLTest extends BaseTest {
    private UserPage userPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage();
        userPage = loginPage.authorize(TEST_BOT.login(), TEST_BOT.password())
                .openUserPage();
    }

    @Test
    @Tag("user")
    @DisplayName("Copy user's URL")
    public void copyUserURL() throws IOException, UnsupportedFlavorException {
        String userURl = userPage.copyUrl();
        Assertions.assertEquals("https://ok.ru/profile/586489906527?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована неправильно");
    }

    @AfterEach
    public void tearDown() {
        logOut();
    }
}