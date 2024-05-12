package ru.mycomp.Homework.Core.Elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ToolBarElement
{
    private static By MESSAGE_BUTTON = byXpath(".//button[@id='msg_toolbar_button']");

    public void openMessages() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("Shold be visible to open message")).click();
    }
}
