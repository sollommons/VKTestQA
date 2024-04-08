package ru.mycomp.Homework.Core.Pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends BasePage{

    private SelenideElement searchField = $(byXpath("//input[@name='st.query']"));
    public NewsPage(){
        checkPage();
    }
    private void checkPage()
    {
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
