package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage implements LoadablePage{
    private static final By creationMenuButton = byXpath(".//*[@data-l='t, createMenu']");
    private static final By searchButton = byXpath(".//*[@data-l='t,chatsSearchInput']");
    private static final By homeButton = byXpath(".//*[@data-tsid='msg_settings_button']");
    public static final By  creationChatButton = byXpath(".//*[@key='create-chat']");
    public static final By  confirmCreationButton = byXpath(".//button[@data-tsid='finish_create_chat_button']");
    public static final By  chatInfoButton = byXpath(".//button[@data-tsid='chat_info_button']");
    public static final By  deleteChatButton = byXpath(".//*[@key='remove-chat']");
    public static final By  confirmRemoveButton = byXpath(".//button[@data-tsid='confirm-primary']");
    public static final By chatTitle = byXpath(".//*[@data-tsid='chat_title']");

    public MessagePage() {
        checkPage();
    }
    @Override
    public boolean checkPage() {
        $(creationMenuButton).shouldBe(visible.because("Should be visible to create dialog"));
        $(searchButton).shouldBe(visible.because("Should be visible to find dialog"));
        $(homeButton).shouldBe(visible.because("Should be visible to fo back home"));
        return true;
    }

    public void createChat() {
        $(homeButton).shouldBe(visible.because("Should be visible to fo back home")).click();
        $(creationMenuButton).shouldBe(enabled.because("Should be visible to create dialog or call")).click();
        $(creationChatButton).shouldBe(visible.because("Should be visible to create dialog")).click();
        $(confirmCreationButton).shouldBe(visible.because("Should be visible to create new dialog")).click();
    }

    public void deleteChat() {
        $(chatInfoButton).shouldBe(visible.because("Should be visible to get info about chat")).click();
        $(deleteChatButton).shouldBe(visible.because("Should be visible to delete dialog")).click();
        $(confirmRemoveButton).shouldBe(visible.because("Should be visible to confirm removing of chat")).click();
    }

    public boolean checkTitle(String title) {
        $(chatTitle).shouldBe(visible.because("Title isn't visible")).shouldHave(text(title));
        return true;
    }
}

