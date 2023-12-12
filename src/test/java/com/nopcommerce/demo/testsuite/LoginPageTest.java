package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    /**
     * 1.userShouldNavigateToLoginPageSuccessFully().
     * Click on login link
     * verify that "Welcome, Please Sign In!" message display
     */

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    /**
     * 2. verifyTheErrorMessageWithInValidCredentials().
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that the Error message
     */

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("tester@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

    /**
     * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that LogOut link is display
     */

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("tester@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

    /**
     * 4. verifyThatUserShouldLogOutSuccessFully()
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Click on LogOut Link
     * Verify that LogIn Link Display
     */

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("tester@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

}
