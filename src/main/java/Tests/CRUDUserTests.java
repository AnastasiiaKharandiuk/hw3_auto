package Tests;

import Pages.EditPage;
import Pages.InsertPage;
import Pages.LoginPage;
import Pages.PlayersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Acer on 04.12.2016.
 */
public class CRUDUserTests {
    private WebDriver driver;
    public PlayersPage playersPage;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.open();
        loginPage.login("admin", "123");
        playersPage = new PlayersPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        playersPage.open();
    }

    /**
     * 1. Click Insert
     * 2. Wait for Player - Insert page to open
     * 3. Verify that we are on the Players - Insert page now
     * 4. Filll fields with data
     * 5. Click Save
     * 6. Verify that we return to the Players page
     */

    @Test
    public void createPlayerTest() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.fillFields();
        insertPage.clickOnSave();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title");
    }

    /**
     * 1. Enter username in the Login field for search
     * 2. Click Search
     * 3. Click Edit icon
     * 4. Wait for Player - Edit page to load
     * 5. Verify that we on Players-Edit page
     */

    @Test
    public void searchForEdit() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnEdit();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Players - Edit", "Wrong title after login");
    }

    /**
     * 1. Enter username in the Login field for search
     * 2. Click Search
     * 3. Click Edit icon
     * 4. Wait for Player - Edit page to load
     * 5. Verify that we on Players-Edit page
     * 6. Fill fields with new data
     */
    @Test
    public void editPlayer() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnEdit();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        EditPage editPage = new EditPage(driver);
        editPage.fillNewFields();

    }

    /**
     * 1. Enter login substring in Login field
     * 2. Click Search
     * 3. Click on Delete icon
     * 4. Wait for "Player has been deleted" message show
     */
    @Test
    public void deletePlayer() {
        playersPage.searchPlayer();
        playersPage.clickOnSearch();
        playersPage.clickOnDelete();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after delete");
        String expectedMsg = "Player has been deleted";
        String actualMsg = PlayersPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");


    }

    /**
     * 1. Click Insert
     * 2. Enter data in the First Name field
     * 3. Enter data in the Last Name field
     * 4. Enter data in the City field
     * 5. Enter data in the Phone field
     * 6. Click Save
     * 7. Verify that  error messages displays
     */
   /* @Test
    public void createPlayerWithoutMandatoryField() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.fillWithoutMandatoryField();
        insertPage.clickOnSave();
        String expectedMsg = "Following errors have been occured:\n" +
                "Username: Value is required and can't be empty\n" +
                "E-mail: Value is required and can't be empty\n" +
                "Password: Value is required and can't be empty\n" +
                "Confirm Password: Value is required and can't be empty";
        String actualMsg = insertPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }*/

    /**
     * 1. Click Insert
     * 2. Enter data in the Username field
     * 3. Enter data in the E-mail field
     * 4. Enter data in the Password field
     * 5. Enter data in the Confirm Password field
     * 6. Click Save
     * 7. Verify that  error messages displays
     */
/*
    @Test
    public void createPlayerWithAlreadyUsedLogin() {
        playersPage.clickOnInsert();
        InsertPage insertPage = new InsertPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        insertPage.open();
        Assert.assertEquals(driver.getTitle(), "Players - Insert", "Wrong title");
        insertPage.alreadyUsedLodin();
        insertPage.clickOnSave();
        String expectedMsg = "Following errors have been occured:\n" +
                "Username: The username is already taken\n"+
                "E-mail: Provided e-mail is already taken. Please enter another e-mail and try again.\n";
        String actualMsg = insertPage.getErrorMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }*/


    @AfterTest
    public void afterTest() {

        driver.quit();
    }

}






