package com.slot.ui;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.slot.DriverFactory;
import com.slot.ReadPropertyFile;

public class SlotTest {
    static DriverFactory objDriver = new DriverFactory();
    static Slot slot;
    static String BASEURL_LOGIN = "https://www.alza.sk";

    @AfterClass
    public void tearDown()
    {
        objDriver.quitDriver();
    }

    @BeforeClass
    static void setUp() {
        slot = new Slot(objDriver.getDriver());
        slot.setWindowsSize(ReadPropertyFile.getVallueWithComma("size").get(0),
                ReadPropertyFile.getVallueWithComma("size").get(1));
        objDriver.getDriver().navigate().to(BASEURL_LOGIN);
    }

    @Test
    public void addOneFavoriteAd() throws InterruptedException {
        slot.clickElement(slot.firstItem);
        slot.clickElement(slot.addToCartButtton);
        objDriver.getDriver().navigate().to(BASEURL_LOGIN);
        slot.clickElement(slot.firstItem);
        slot.clickElement(slot.addToCartButtton);
        int number = Integer.parseInt(slot.countOfItems.getText());
        System.out.println(number);
        Assert.assertEquals(number, 2);
    }
}
