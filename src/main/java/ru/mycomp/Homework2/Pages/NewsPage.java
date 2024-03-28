package ru.mycomp.Homework2.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NewsPage {

    private SelenideElement searchField = $x("//input[@name='st.query']");
    private SelenideElement mainPageButton = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public void set(String name){
        searchField.shouldBe(visible).setValue(name);
        searchField.shouldHave(value(name));
    }

    public void search(){
        searchField.click();
        searchField.pressEnter();
    }

    public MainPage goToMainPage(){
        mainPageButton.shouldBe(visible).click();
        return new MainPage();
    }
}
