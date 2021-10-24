package com.slot.ui;

import java.io.IOException;

import org.junit.jupiter.api.*;

import com.slot.DriverFactory;
import com.slot.ReadPropertyFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SlotTest {
    static DriverFactory objDriver = new DriverFactory();
    ReadPropertyFile readPropertyFile = new ReadPropertyFile();
    static Slot slot;
    String BASEURL_LOGIN = "http://test-app.d6.dev.devcaz.com/admin/login";
    String BASEURL = "http://test-app.d6.dev.devcaz.com/";
    String LOGIN = "admin1";
    String PASSWORD = "[9k<k8^z!+$$GkuP";


    @BeforeAll
    static void setUp() throws IOException, InterruptedException {
        slot = new Slot(objDriver.getDriver());
        slot.setWindowsSize(ReadPropertyFile.getVallueWithComma("size").get(0),
                ReadPropertyFile.getVallueWithComma("size").get(1));
    }

    @BeforeEach
    public void load() throws IOException, InterruptedException {
        objDriver.getDriver().navigate().to(BASEURL_LOGIN);
        slot.setElementText(slot.loginField, LOGIN);
        slot.setElementText(slot.userPasswordField, PASSWORD);
        slot.submitButton.click();
    }

    @AfterAll
    static void tearDown() {
        objDriver.quitDriver();
    }

    @AfterEach
    public void clearSession() {
        objDriver.deleteCookies();
    }

    @Test
    public void addOneFavoriteAd() throws InterruptedException, IOException {

        slot.waitForElement(slot.headerLogoCasino);
        assertTrue(slot.headerLogoCasino.isDisplayed(), "ok");
    }

    @Test
    public void usersTableWasLoaded() throws InterruptedException, IOException {
        objDriver.getDriver().navigate().to(BASEURL + "user/player/admin");
        assertTrue(slot.paymentSystemTransactionGrid.isDisplayed(), "ok");
    }

    @Test
    public void usersTableSorted() throws InterruptedException, IOException {
        objDriver.getDriver().navigate().to(BASEURL + "user/player/admin");
        slot.setElementText1();
    }
}
