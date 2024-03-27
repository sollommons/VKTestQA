package ru.mycomp.Homework2.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NewsPage {

    private SelenideElement searchField = $x("//input[@name='st.query']");

    public void set(String name){
        searchField.setValue(name);
        searchField.shouldHave(value(name));
    }

    public void search(){
        searchField.click();
        searchField.pressEnter();
    }
}
