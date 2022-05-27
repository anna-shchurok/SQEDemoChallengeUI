package com.sample.test.demo.page_objects;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.helpers.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PizzaOrderFormPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(PizzaOrderFormPage.class);

    @FindBy(id = "pizza1Pizza")
    private WebElement pizza1Dropdown;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
    private WebElement pizza1Toppings1;
    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
    private WebElement pizza1Toppings2;

    @FindBy(id = "pizza1Qty")
    private WebElement pizza1Quantity;
    @FindBy(id = "pizza1Cost")
    private WebElement pizza1Cost;

    @FindBy(id = "ccpayment")
    private WebElement radioCreditCard;
    @FindBy(id = "cashpayment")
    private WebElement radioCash;

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "placeOrder")
    private WebElement placeOrderButton;
    @FindBy(id = "reset")
    private WebElement resetButton;

    @FindBy(id = "dialog")
    private WebElement dialog;

    @FindBy(xpath = "//div[@id='dialog']/p")
    private WebElement dialogText;

    public PizzaOrderFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    String getPageName() {
        return "[Pizza Order Form]";
    }

    @Override
    WebElement getRequiredElement() {
        return placeOrderButton;
    }

    public PizzaTypes selectAnyPizza() {
        LOGGER.info("Selecting random option for [Pizza 1] field");
        String selectedOption = selectAnyValueDropdown(pizza1Dropdown);
        LOGGER.info("Selected option for [Pizza 1] field: " + selectedOption);
        return PizzaTypes.getPizzaTypeByName(selectedOption);
    }

    public PizzaToppings selectAnyTopping1() {
        LOGGER.info("Selecting random option for [Topping 1] field");
        String selectedOption = selectAnyValueDropdown(pizza1Toppings1);
        LOGGER.info("Selected option for [Topping 1] field: " + selectedOption);
        return PizzaToppings.getPizzaToppingByName(selectedOption);
    }

    public PizzaToppings selectAnyTopping2() {
        LOGGER.info("Selecting random option for [Topping 2] field");
        String selectedOption = selectAnyValueDropdown(pizza1Toppings1);
        LOGGER.info("Selected option for [Topping 2] field: " + selectedOption);
        return PizzaToppings.getPizzaToppingByName(selectedOption);
    }

    public PizzaOrderFormPage updateQuantityWithAnyNumber() {
        return updateQuantity(Randomizer.randomNumbers(1));
    }

    public PizzaOrderFormPage updateQuantity(int quantity) {
        return updateQuantity(String.valueOf(quantity));
    }


    public PizzaOrderFormPage updateQuantity(String quantity) {
        LOGGER.info("Setting [{}] value for [Quantity] field", quantity);
        clearAndType(pizza1Quantity, quantity);
        return this;
    }

    public PizzaOrderFormPage verifyValueOfQuantity(int expectedQuantity) {
        return verifyValueOfQuantity(String.valueOf(expectedQuantity));
    }

    public PizzaOrderFormPage verifyValueOfQuantity(String expectedQuantity) {
        LOGGER.info("Verifying [Quantity] field has [{}] value", expectedQuantity);
        Assert.assertEquals(getElementValue(pizza1Quantity), expectedQuantity, "Incorrect value for [Quantity] field");
        return this;
    }

    public PizzaOrderFormPage fillNameWithAnyString() {
        String randomString = Randomizer.randomStringChars();
        LOGGER.info("Setting [{}] value for [Name] field", randomString);
        clearAndType(name, randomString);
        return this;
    }

    public PizzaOrderFormPage fillEmailWithAnyEmail() {
        String randomString = Randomizer.randomStringChars() + "@test.must.go.on";
        LOGGER.info("Setting [{}] value for [Email] field", randomString);
        clearAndType(email, randomString);
        return this;
    }

    public PizzaOrderFormPage fillPhoneWithAnyNumbers() {
        String randomNumber = Randomizer.randomNumbers();
        LOGGER.info("Setting [{}] value for [Phone] field", randomNumber);
        clearAndType(phone, randomNumber);
        return this;
    }

    public PizzaOrderFormPage selectAnyPayment() {
        List<WebElement> radioButtons = Arrays.asList(radioCreditCard, radioCash);
        int randomIndex = new Random().nextInt(radioButtons.size());
        WebElement selectedRadioButton = radioButtons.get(randomIndex);
        LOGGER.info("Selecting [{}] for [Payment] option", getElementValue(selectedRadioButton));
        selectedRadioButton.click();
        return this;
    }

    public PizzaOrderFormPage clickPlaceOrder() {
        LOGGER.info("Clicking [Place Order]");
        placeOrderButton.click();
        return this;
    }

    public PizzaOrderFormPage clickReset() {
        LOGGER.info("Clicking [Reset]");
        resetButton.click();
        return this;
    }

    public PizzaOrderFormPage verifySuccessOrder(PizzaTypes pizza) {
        LOGGER.info("Verify success modal with pizza name [{}]", pizza.getDisplayName());
        String expectedMessage = String.format("Thank you for your order! TOTAL: %s %s", pizza.getCost(), pizza.getDisplayName());
        return verifyMessageInModal(expectedMessage);
    }

    public PizzaOrderFormPage verifyMessageInModal(String expectedMessage) {
        LOGGER.info("Verify modal with message [{}]", expectedMessage);
        Assert.assertTrue(isElementPresentWithWaiting(dialog), "Dialog is not shown");
        Assert.assertEquals(dialogText.getText(), expectedMessage, "Dialog text is incorrect");
        return this;
    }

    public void verifyDefaultFormView() {
        LOGGER.info("Verify default clear form view");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getSelectedValueOfDropdown(pizza1Dropdown), "Choose Pizza", "Default value for [Pizza 1] field is incorrect");
        softAssert.assertEquals(getSelectedValueOfDropdown(pizza1Toppings1), "Choose a Toppings 1", "Default value for [Topping 1] field is incorrect");
        softAssert.assertEquals(getSelectedValueOfDropdown(pizza1Toppings2), "Choose a Toppings 2", "Default value for [Topping 2] field is incorrect");
        softAssert.assertEquals(getElementValue(pizza1Quantity), "0", "Default value for [Quantity] field is incorrect");
        softAssert.assertEquals(getElementValue(pizza1Cost), "0", "Default value for [Cost] field is incorrect");
        softAssert.assertEquals(getElementValue(name), "", "Default value for [Name] field is incorrect");
        softAssert.assertEquals(getElementValue(email), "", "Default value for [Email] field is incorrect");
        softAssert.assertEquals(getElementValue(phone), "", "Default value for [Phone] field is incorrect");
        softAssert.assertFalse(radioCreditCard.isSelected(), "Default value for [Credit card] field is incorrect");
        softAssert.assertFalse(radioCash.isSelected(), "Default value for [Cash on Pickup] field is incorrect");
        softAssert.assertAll();
    }
}
