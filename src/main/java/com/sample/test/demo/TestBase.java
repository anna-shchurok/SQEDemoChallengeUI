package com.sample.test.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

public class TestBase {

    private Configuration config;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String url;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        config = new Configuration();
        url = config.getUrl();
        initDriver();
        navigateToSite();
    }

    protected void navigateToSite() {
        getDriver().get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            driver.get().quit();
            driver.set(null);
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    private void initDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else if (config.getPlatform().equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            } else {
                throw new IllegalArgumentException("No platform supported: " + config.getPlatform());
            }
            driver.set(new ChromeDriver());
        } else {
            fail("Unsupported browser " + config.getBrowser());
        }
    }
}
