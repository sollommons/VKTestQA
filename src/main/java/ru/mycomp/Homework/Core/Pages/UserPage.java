package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class UserPage extends BasePage{
    private  SelenideElement shareButton = $(byXpath("//*[@data-l='outlandertarget,share,t,share']"));
    private SelenideElement settingButton = $(byXpath("//*[@data-l='outlandertarget,settings,t,settings']"));
    private SelenideElement publicateButton =  $(byXpath("//button[@data-l='t,pf_dropdown']"));
    private SelenideElement noticeButton = $(byXpath("//span[@data-l='t,feed.posting.ui.input']"));
    private SelenideElement textOfPublicationField = $(byXpath("//div[@data-module='postingForm/mediaText']"));

    private SelenideElement submitPublicationButton = $(byXpath("//button[@data-l='t,button.submit']"));
    private SelenideElement publicationActionButton = $(byXpath("//div[@data-l='t,feed-actions-menu']"));
    private SelenideElement deletePublicationButton = $(byText("Удалить заметку"));
    private SelenideElement confirmDeleteButton = $(byXpath("//a[@class='button-pro __small form-actions_yes']"));

    private SelenideElement myEventsButton = $(byXpath("//a[@id='tab-344']"));
    public UserPage() {
        checkPage();
    }
    private void checkPage(){
        shareButton.shouldBe(visible);
        settingButton.shouldBe(visible);
        myEventsButton.shouldBe(visible);

    }
    public String copyUrl() throws IOException, UnsupportedFlavorException {
        shareButton.shouldBe(visible).click();
        $(byText("Копировать ссылку")).shouldBe(visible).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public void chooseToPublicate() {
        publicateButton.shouldBe(visible).click();
        noticeButton.shouldBe(visible).click();
    }

    public void publicate() {
        textOfPublicationField.shouldBe(visible).setValue("Приветственная публикация");
        submitPublicationButton.shouldBe(enabled).click();
    }

    public String checkPublication(){
        return $(byText("Приветственная публикация")).text();
    }

    public void deletePublication() {
        publicationActionButton.shouldBe(visible).click();
        deletePublicationButton.shouldBe(visible).click();
        confirmDeleteButton.shouldBe(visible).click();
    }

    public SettingPage openSettings()
    {
        settingButton.shouldBe(visible).click();
        return new SettingPage();
    }
}
