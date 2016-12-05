package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Pages.LoginPage.URL;

/**
 * Created by Acer on 04.12.2016.
 */
public class EditPage {

    private WebDriver driver;

    public EditPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public final String username =  "jack2043";
    public String email = username + "@gmail.com";

    public void assertFields() {
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_email")).getText(), email, "Invalid data");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_fname")).getText(), "Jack", "Invalid data");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_lname")).getText(), "Nicolson", "Invalid data");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_city")).getText(), "Las Vegas", "Invalid data");
        Assert.assertEquals(driver.findElement(By.id("ff14642ac1c__us_phone")).getText(), "9379992", "Invalid data");
    }

    public void fillNewFields() {
        WebElement newMail = driver.findElement(By.id("ff14642ac1c__us_email"));
        newMail.clear();
        newMail.sendKeys("test3@gmail.com");

        WebElement FNameChange = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FNameChange.clear();
        String newFname = "Albert";
        FNameChange.sendKeys(newFname);

        WebElement LNameChange = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LNameChange.clear();
        String newLname = "Enschtein";
        LNameChange.sendKeys(newLname);

        WebElement cityChange = driver.findElement(By.id("ff14642ac1c__us_city"));
        cityChange.clear();
        String newCity = "Berlin";
        cityChange.sendKeys(newCity);

        WebElement phoneChange = driver.findElement(By.id("ff14642ac1c__us_phone"));
        phoneChange.clear();
        String new_phone = "123456789";
        phoneChange.sendKeys(new_phone);

        WebElement saveButton = driver.findElement(By.xpath("//*[@name='button_save']"));
        saveButton.click();


    }

    //WebElement saveButton = driver.findElement(By.xpath("//*[@name='button_save']"));
    //saveButton.click();
}
