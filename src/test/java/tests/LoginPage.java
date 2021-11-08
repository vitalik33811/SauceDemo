package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {

    @Test
    public void emptyFieldsLoginPageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "");
    }
    @Test
    public void fillInOneFieldTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
    }
    @Test
    public void fillInTheFieldsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
    public void fillInOneFieldErrorMessageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Epic sadface: Password is required");
    }
    @Test
    public void emptyFieldsLoginErrorMessageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.logindErrorMessage(), "Epic sadface: Username is required");
    }
}

