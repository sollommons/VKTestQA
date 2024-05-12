package ru.mycomp.Homework.Core.Objects;

import org.testng.annotations.DataProvider;

public class TestBotsDataProvider {
    @DataProvider(name = "testBotsData")
    public Object[][] dataTestBots(){
        return new Object[][]{
                {new TestBot("technopol60", "technopolisPassword")},
                {new TestBot("technopol44", "technopolisPassword")},
                {new TestBot("technopol57", "technopolisPassword")},
        };
    }
}
