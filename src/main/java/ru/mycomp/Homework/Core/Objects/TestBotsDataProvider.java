package ru.mycomp.Homework.Core.Objects;

import org.testng.annotations.DataProvider;

public class TestBotsDataProvider {
    @DataProvider(name = "testBotsData")
    public Object[][] dataTestBots(){
        return new Object[][]{
                {"technopol60", "technopolisPassword"},
                {"technopol44", "technopolisPassword"},
                {"technopol57", "technopolisPassword"},
        };
    }
}
