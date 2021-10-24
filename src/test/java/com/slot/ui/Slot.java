package com.slot.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slot.BasePageObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Slot extends BasePageObject {

    public Slot(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"UserLogin_username\"]")
    WebElement loginField;

    @FindBy(xpath = "//*[@id=\"UserLogin_password\"]")
    WebElement userPasswordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"header-logo\"]")
    WebElement headerLogoCasino;

    @FindBy(xpath = "//*[@id=\"payment-system-transaction-grid_c1\"]")
    WebElement paymentSystemTransactionGrid;

    @FindBy(xpath = "//*[@id=\"payment-system-transaction-grid_c1\"]//a")
    WebElement userNameTitle;

    public void setElementText1() throws InterruptedException {
        waitForElement(userNameTitle);
        userNameTitle.click();
        Thread.sleep(1000);
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"payment-system-transaction-grid\"]/table/tbody/tr[*]/td[2]"));

        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        assertEquals(sortedList, obtainedList);
    }

    public void setElementText(WebElement element, String text) throws InterruptedException {
        waitUntilElementIsLoaded(element);
        element.sendKeys(text);
    }

    public void waitForElement(WebElement element) throws InterruptedException {
        waitUntilElementIsLoaded(element);
    }
}
