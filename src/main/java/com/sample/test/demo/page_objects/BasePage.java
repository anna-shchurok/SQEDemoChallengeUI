package com.sample.test.demo.page_objects;

import com.sample.test.demo.helpers.DriverBasis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public abstract class BasePage extends DriverBasis {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageOpened() {
        Assert.assertTrue(isElementPresentWithWaiting(getRequiredElement()), getPageName() + " is not opened");
    }

    public static <T extends BasePage> T verify(T page) {
        page.verifyPageOpened();
        return page;
    }

    abstract String getPageName();

    abstract WebElement getRequiredElement();
}
