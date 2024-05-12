package ru.mycomp.Homework.Core.Elements;

import org.openqa.selenium.By;
import ru.mycomp.Homework.Core.Pages.LoadablePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface NavigationBlockElement {
    public static By userButton = byXpath("//*[@data-l='t,userPage']");
    public static By newsButton = byXpath("//*[@data-l='t,userMain']");
    public static By hobbyButton = byXpath("//*[@data-l='t,hobby']");
    public static By friendsButton = byXpath("//*[@data-l='t,userFriend']");
    public static By photoButton = byXpath("//*[@data-l='t,userPhotos']");
    public static By groupsButton = byXpath("//*[@data-l='t,userAltGroup']");
    public static By gamesButton = byXpath("//*[@data-l='t,appShowcaseHD']");
    public static By giftsButton = byXpath("//*[@data-l='t,giftsFront']");
    public static By recomendationButton = byXpath("//*[@data-l='t,discovery']");
    public static By appsButton = byXpath("//*[@data-l='t,bizApps']");
    public static By datingButton = byXpath("//*[@data-l='t,appsDating']");

}
