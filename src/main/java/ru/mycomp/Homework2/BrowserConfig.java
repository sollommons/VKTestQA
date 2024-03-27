package ru.mycomp.Homework2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Browsers.CHROME;

public class BrowserConfig {
    public  void setupConf(){
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://ok.ru/";
    }

    public  void endJob(){
        Selenide.closeWebDriver();
    }
}
