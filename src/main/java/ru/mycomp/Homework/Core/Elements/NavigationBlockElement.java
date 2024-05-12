package ru.mycomp.Homework.Core.Elements;

import org.openqa.selenium.By;
import ru.mycomp.Homework.Core.Pages.LoadablePage;
import ru.mycomp.Homework.Core.Pages.UserPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NavigationBlockElement implements LoadablePage{
    private static final By userButton = byXpath("//*[@data-l='t,userPage']");
    private static final By newsButton = byXpath("//*[@data-l='t,userMain']");
    private static final By hobbyButton = byXpath("//*[@data-l='t,hobby']");
    private static final By friendsButton = byXpath("//*[@data-l='t,userFriend']");
    private static final By photoButton = byXpath("//*[@data-l='t,userPhotos']");
    private static final By groupsButton = byXpath("//*[@data-l='t,userAltGroup']");
    private static final By gamesButton = byXpath("//*[@data-l='t,appShowcaseHD']");
    private static final By giftsButton = byXpath("//*[@data-l='t,giftsFront']");
    private static final By recomendationButton = byXpath("//*[@data-l='t,discovery']");
    private static final By appsButton = byXpath("//*[@data-l='t,bizApps']");
    private static final By datingButton = byXpath("//*[@data-l='t,appsDating']");

    @Override
    public boolean checkPage() {
        $(newsButton).shouldBe(visible.because("News button should be on every page"));
        $(friendsButton).shouldBe(visible.because("Friends of Subscribing button should be on every page"));
        $(groupsButton).shouldBe(visible.because("Groups info button should be on every page"));
        $(recomendationButton).shouldBe(visible.because("Recommendation button should be on every page"));
        $(photoButton).shouldBe(visible.because("Photo button should be on every page"));
        return true;
    }

    public UserPage openUserPage() {
        $(userButton).shouldBe(visible.because("User button should be visible to click")).click();
        return new UserPage();
    }
}
