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

public class Slot extends BasePageObject {

    public Slot(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"count\"][1]")
    WebElement countOfItems;

    @FindBy(xpath = "//*[@class=\"quantity\"]")
    WebElement addToCartButtton;

    @FindBy(xpath = "//*[@class=\"item\"][1]")
    WebElement firstItem;

    public void setElementText(WebElement element, String text) throws InterruptedException {
        waitUntilElementIsLoaded(element);
        element.sendKeys(text);
    }

    public void waitForElement(WebElement element) throws InterruptedException {
        waitUntilElementIsLoaded(element);
    }

    public void clickElement(WebElement element) throws InterruptedException {
        waitUntilElementIsLoaded(element);
        element.click();
    }

}
