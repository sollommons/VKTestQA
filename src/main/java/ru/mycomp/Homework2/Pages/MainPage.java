package ru.mycomp.Homework2.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private  SelenideElement shareButton = $x("//*[@id=\"hook_Block_MainMenu\"]/div/ul/li[2]/button");

    public void copyUrl(){
        shareButton.shouldBe(visible).click();
    }
}
