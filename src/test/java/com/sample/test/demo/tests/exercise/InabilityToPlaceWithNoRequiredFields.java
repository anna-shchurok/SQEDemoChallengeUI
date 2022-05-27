package com.sample.test.demo.tests.exercise;

import com.sample.test.demo.BaseUiTest;
import com.sample.test.demo.constants.TestGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.sample.test.demo.page_objects.BasePage.verify;

public class InabilityToPlaceWithNoRequiredFields extends BaseUiTest {
    private static final String NO_NAME = "Missing name";
    private static final String NO_PHONE = "Missing phone number";

    @DataProvider(parallel = true)
    private Object[][] requiredFieldState() {
        return new Object[][]{
                {true, false, NO_NAME},
                {false, true, NO_PHONE},
                {true, true, NO_NAME + "\n" + NO_PHONE}
        };
    }

    @Test(groups = {TestGroups.NEGATIVE},
            description = "NEGATIVE - INABILITY TO PLACE ORDER WITH NO REQUIRED FIELDS", dataProvider = "requiredFieldState")
    public void unableToPlace(boolean emptyName, boolean emptyPhone, String expectedMessage) {
        verify(getPizzaOrderPage()).selectAnyPizza();
        getPizzaOrderPage().updateQuantityWithAnyNumber();

        if (!emptyName)
            getPizzaOrderPage().fillNameWithAnyString();
        if (!emptyPhone)
            getPizzaOrderPage().fillPhoneWithAnyNumbers();

        getPizzaOrderPage().clickPlaceOrder()
                .verifyMessageInModal(expectedMessage);
    }
}
