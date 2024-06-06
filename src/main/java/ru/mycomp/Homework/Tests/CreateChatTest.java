package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.MessagePage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;


public class CreateChatTest extends BaseTest {

    MessagePage msgPage;
    @BeforeEach
    public void setup()
    {
        msgPage = new LoginPage()
                .authorize(TEST_BOT.login(), TEST_BOT.password())
                .openMsgPage();
    }

    @Test
    @Tag("Messages")
    @DisplayName("Create New Chat")
    public void createChat()  {
        msgPage.createChat();
        Assertions.assertTrue(msgPage.checkTitle("Пустой чат"));
    }

    @AfterEach
    public void tearDown() {
        msgPage.deleteChat();
        logOut();
    }
}
