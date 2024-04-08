package ru.mycomp.Homework.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mycomp.Homework.Core.Pages.NewsPage;
import ru.mycomp.Homework.Core.Pages.LoginPage;



public class LoginTest extends BaseTest{
    private LoginPage loginPage = new LoginPage();

    @Test
    public void loginToOK() {
        loginPage.open();
        loginPage.setInfo("technopol60", "technopolisPassword");
        NewsPage newsPage = loginPage.login();
        Assertions.assertTrue(newsPage.checkMoment(), "Открылась не та страница");
    }
}
