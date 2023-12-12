package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    /**
     * 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
     * Click on Register Link
     * Verify "Register" text
     */

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    /**
     * 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
     * Click on Register Link
     * Click on "REGISTER" button
     * Verify the error message "First name is required."
     * Verify the error message "Last name is required."
     * Verify the error message "Email is required."
     * Verify the error message "Password is required."
     * Verify the error message "Password is required."
     */

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("smart.test@gmail.com");
        loginPage.enterPassword("test1");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

    /**
     * 2. verifyThatUserShouldCreateAccountSuccessfully()
     * Click on Register Link
     * Select gender "Female"
     * Enter firstname
     * Enter lastname
     * Select day
     * Select month
     * Select year
     * Enter email
     * Enter password
     * Enter Confirm Password
     * Click on "REGISTER" button
     * Verify message "Your registration completed"
     */
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        registerPage.clickOnRegisterLink();
        registerPage.genderRadioButton();
        registerPage.enterFirstName("Smart");
        registerPage.enterLastName("Tester");
        registerPage.enterEmail("tester@gmail.com");
        registerPage.enterPassword("test123");
        registerPage.enterConfirmPassword("test123");
        registerPage.clickOnRegisterButton();
        String expectedText = "Your registration completed";
        String actualText = registerPage.getRegisterText();
        Assert.assertEquals(expectedText, actualText , "Registration completed message displayed");
    }
}
