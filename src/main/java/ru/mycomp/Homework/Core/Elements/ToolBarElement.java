package ru.mycomp.Homework.Core.Elements;

import org.openqa.selenium.By;
import ru.mycomp.Homework.Core.Pages.LoadablePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ToolBarElement implements LoadablePage
{
    private static final By MESSAGE_BUTTON = byXpath(".//*[@data-l='t,messages']");
    public static final By DISCUSSION_BUTTON = byXpath(".//*[@data-l='t,discussions']");
    public static final By NOTIFICATION_BUTTON = byXpath(".//*[@data-l='t,notifications']");

    public void openMessages() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("Should be visible to open message")).click();
    }

    @Override
    public boolean checkPage() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("Should be visible to open message"));
        $(DISCUSSION_BUTTON).shouldBe(visible.because("Should be visible to open discussion"));
        $(NOTIFICATION_BUTTON).shouldBe(visible.because("Should be visible to open notification"));
        return true;
    }
}
