package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage{

    private SelenideElement friendProfileButton = $(byXpath("//a[@href='/profile/576417343743']"));

   public SearchPage(){
       checkPage();
   }
    private void checkPage(){

    }
    public FriendPage openFriendPage() {
        friendProfileButton.shouldBe(visible).click();
        return new FriendPage();
    }


}
