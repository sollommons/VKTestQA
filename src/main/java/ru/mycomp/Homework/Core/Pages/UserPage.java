package ru.mycomp.Homework.Core.Pages;

import org.openqa.selenium.By;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends BasePage {

    private static final By shareButton = byXpath("//*[@data-l='outlandertarget,share,t,share']");
    private static final By settingButton = byXpath("//*[@data-l='outlandertarget,settings,t,settings']");
    private static final By publicateButton = byXpath("//button[@data-l='t,pf_dropdown']");
    private static final By noticeButton = byXpath("//span[@data-l='t,feed.posting.ui.input']");
    private static final By textOfPublicationField = byXpath("//div[@data-module='postingForm/mediaText']");
    private static final By submitPublicationButton = byXpath("//button[@data-l='t,button.submit']");
    private static final By publicationActionButton = byXpath("//div[@data-l='t,feed-actions-menu']");
    private static final By deletePublicationButton = byText("Удалить заметку");
    private static final By confirmDeleteButton = byXpath("//*[@class='form-actions']/a[1]");
    private static final By myEventsButton = byXpath("//*[@data-l='t,filter']/a[3]");
    public UserPage() {
        checkPage();
    }

    @Override
    public boolean checkPage() {
        super.checkPage();
        $(shareButton).shouldBe(visible.because("Share button should be visible user page"));
        $(settingButton).shouldBe(visible.because("Settings button should be visible user page"));
        $(myEventsButton).shouldBe(visible.because("Events button should be visible user page"));
        return true;
    }

    public String copyUrl() throws IOException, UnsupportedFlavorException {
        $(shareButton).shouldBe(interactable.because("Share button should be interactable to share")).click();
        $(byText("Копировать ссылку")).shouldBe(visible.because("Copy button should be visible to use")).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public UserPage chooseToPublicate() {
        $(publicateButton).shouldBe(interactable.because("Publicate button should be interactable to publicate")).click();
        $(noticeButton).shouldBe(visible.because("Noitce button should be visible to choose")).click();
        return this;
    }

    public UserPage publicate() {
        $(textOfPublicationField).shouldBe(visible.because("Field should be visible to write")).setValue("Приветственная публикация");
        $(submitPublicationButton).shouldBe(enabled.because("Submit button should be enabled to publicate")).click();
        return this;
    }

    public String checkPublication() {
        return $(byText("Приветственная публикация")).text();
    }

    public void deletePublication() {
        $(publicationActionButton).shouldBe(interactable.because("actions should be interactable to use")).click();
        $(deletePublicationButton).shouldBe(visible.because("delete button should be visible to choose")).click();
        $(confirmDeleteButton).shouldBe(visible.because("Confirm button should be visible to delete")).click();
    }

    public SettingPage openSettings() {
        $(settingButton).shouldBe(visible.because("Settings button should be visible to open settings")).click();
        return new SettingPage();
    }
}
