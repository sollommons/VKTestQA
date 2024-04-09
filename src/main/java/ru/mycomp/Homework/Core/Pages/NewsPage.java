package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends BasePage{

    private SelenideElement searchField = $(byXpath("//input[@name='st.query']"));
    private SelenideElement momentsButton = $(byXpath("//button[@data-l='t,to_moments']"));
    private SelenideElement upperHobbyButton = $(byXpath("//button[@data-l='t,to_hobbies']"));
    private SelenideElement blockFriendsStream = $(byXpath("//div[@data-sticky-id='friendsStream']"));

    public NewsPage(){
        checkPage();
    }
    private void checkPage()
    {
        momentsButton.shouldBe(visible);
        upperHobbyButton.shouldBe(visible);
        blockFriendsStream.shouldBe(visible);
    }
    public void set(String name){
        searchField.shouldBe(visible).setValue(name);
        searchField.shouldHave(value(name));
    }


    public SearchPage search(){
        searchField.shouldBe(visible).click();
        searchField.shouldBe(visible).pressEnter();
        return new SearchPage();
    }


    public UserPage openUserPage(){
        userButton.shouldBe(visible).click();
        return new UserPage();
    }


    public boolean checkMoment() {
        return (($(byText("Моменты")).exists())? true:false);

    }
}