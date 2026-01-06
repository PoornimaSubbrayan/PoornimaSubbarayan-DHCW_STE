package utility;

import java.util.List;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UiInteractables extends Hooks {

    // This class contains all the reusable methods for interacting with UI elements
    // This reusable method is used to clear and enter text details in a textbox using id
    public static void sendKeysByID(WebDriver driver, String id, String text) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(new CharSequence[]{text});
    }

    // This reusable method is used to clear and enter text details in a textbox using xpath
    public static void sendKeysByXpath(WebDriver driver, String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(new CharSequence[]{text});
    }

    //This reusable method is used to get the title of the page
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // This reusable method is used to click the element by xpath
    public static void clickByXpath(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    // This reusable method is used to find the element by xpath and return the element
    public static WebElement findByIDElement(WebDriver driver, String id) {
        return driver.findElement(By.id(id));
    }

    // This reusable method is used to find the element by xpath and return the element
    public static WebElement findByXpathElement(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    // This reusable method is used to find the elements by xpath and return the elements
    public static List<WebElement> findByXpathElements(WebDriver driver, String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

}
