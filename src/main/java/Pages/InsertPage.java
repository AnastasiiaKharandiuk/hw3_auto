package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Acer on 04.12.2016.
 */
public class InsertPage {
    private WebDriver driver;

    private static final String URL_INS = "http://80.92.229.236:81/players/insert";

    public InsertPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() { driver.get(URL_INS); }

    public final String username =  "jack"+RandomStringUtils.random(5,"53421");
    public String email = username + "@gmail.com";

    public void fillFields() {
        WebElement loginInput = driver.findElement(By.id("ff14642ac1c__us_login"));
        loginInput.sendKeys(username);

        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailInput.sendKeys(email);

        WebElement passInput = driver.findElement(By.id("ff14642ac1c__us_password"));
        String password = "123456789";
        passInput.sendKeys(password);

        WebElement confPassInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confPassInput.sendKeys(password);

        WebElement FNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        String fname = "Jack";
        FNameInput.sendKeys(fname);

        WebElement LNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        String lname = "Nicolson";
        LNameInput.sendKeys(lname);

        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        String city = "Las Vegas";
        cityInput.sendKeys(city);

        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        String phone = "9379992";
        phoneInput.sendKeys(phone);
    }

    /*public void fillWithoutMandatoryField() {
        WebElement FNameInput = driver.findElement(By.id("ff14642ac1c__us_fname"));
        String fname = "Jack";
        FNameInput.sendKeys(fname);

        WebElement LNameInput = driver.findElement(By.id("ff14642ac1c__us_lname"));
        String lname = "Nicolson";
        LNameInput.sendKeys(lname);

        WebElement cityInput = driver.findElement(By.id("ff14642ac1c__us_city"));
        String city = "Las Vegas";
        cityInput.sendKeys(city);

        WebElement phoneInput = driver.findElement(By.id("ff14642ac1c__us_phone"));
        String phone = "9379992";
        phoneInput.sendKeys(phone);
    }

   /* public void alreadyUsedLodin(){
        WebElement loginInput = driver.findElement(By.id("ff14642ac1c__us_login"));
        loginInput.sendKeys("jack2043");

        WebElement emailInput = driver.findElement(By.id("ff14642ac1c__us_email"));
        emailInput.sendKeys("jack2043@gmail.com");

        WebElement passInput = driver.findElement(By.id("ff14642ac1c__us_password"));
        String password = "123456789";
        passInput.sendKeys(password);

        WebElement confPassInput = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        confPassInput.sendKeys(password);

    }*/

    public void clickOnSave() {
        WebElement saveButton = driver.findElement(By.name("button_save"));
        saveButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//*[contains(@class, 'errors_container')]"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
    }

}
