package ru.mycomp.Homework.Tests;

import org.junit.jupiter.api.*;
import ru.mycomp.Homework.Core.Objects.MsgRegistry;
import ru.mycomp.Homework.Core.Pages.LoginPage;
import ru.mycomp.Homework.Core.Pages.MessagePage;

import static ru.mycomp.Homework.Core.Pages.BasePage.logOut;

public class WriteMsgTest extends BaseTest {

    MessagePage msgPage;
    @BeforeEach
    public void setup()
    {
        msgPage = new LoginPage()
                .authorize(TEST_BOT.login(), TEST_BOT.password())
                .openMsgPage()
                .createChat();
    }

    @RepeatedTest(value = 3, name = "Test number {currentRepetition}/{totalRepetitions}")
    @Tag("Messages")
    @DisplayName("writeMsg")
    public void writeMsg() {
        msgPage.writeMsg(MsgRegistry.getMsg());
    }

    @AfterEach
    public void tearDown() {
        msgPage.deleteChat();
        logOut();
    }
}
