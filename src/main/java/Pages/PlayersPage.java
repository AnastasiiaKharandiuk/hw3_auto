package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Acer on 04.12.2016.
 */
public class PlayersPage {
    private static final String URL_PLAYERS = "http://80.92.229.236:81/players";

    private static WebDriver driver;

    public PlayersPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get(URL_PLAYERS);
    }

    public void clickOnInsert() {
        driver.findElement(By.xpath("//*[@title='Insert']"));
    }

    public void searchPlayer() {
        WebElement playerInput = driver.findElement(By.id("723a925886__login"));
        playerInput.clear();
        String username =  "jack2043";
        playerInput.sendKeys(username);
    }

    public void clickOnSearch() {
        WebElement searchButton = driver.findElement(By.xpath(".//*[@name='search']"));
        searchButton.click();

    }

    public void clickOnEdit() {
        WebElement editButton = driver.findElement(By.xpath("//*[@alt='Edit']"));
        editButton.click();
    }

    public void clickOnDelete() {
        WebElement deleteButton = driver.findElement(By.xpath("//*[@alt='Delete']"));
        deleteButton.click();
    }

   // public static String getMessage() {
        //WebElement MsgElement = driver.findElement(By.xpath(".//*[@id='r_29928']/td[14]/a/img"));
        //String Msg = MsgElement.getText();
        //return Msg;
    //}

    public static String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//*[@id='datagrid_flashmessagespanel__723a925886']/ul/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }


}
