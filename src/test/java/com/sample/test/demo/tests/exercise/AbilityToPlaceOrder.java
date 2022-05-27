package com.sample.test.demo.tests.exercise;

import com.sample.test.demo.BaseUiTest;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.constants.TestGroups;
import org.testng.annotations.Test;

import static com.sample.test.demo.page_objects.BasePage.verify;

public class AbilityToPlaceOrder extends BaseUiTest {

    @Test(groups = {TestGroups.HAPPY_PATH, TestGroups.SMOKE},
            description = "SMOKE - HAPPY PATH - ABILITY TO PLACE ORDER")
    public void placeTheOrder() {
        PizzaTypes selectedPizza = verify(getPizzaOrderPage()).selectAnyPizza();
        getPizzaOrderPage().updateQuantity(1)
                .fillNameWithAnyString()
                .fillPhoneWithAnyNumbers()
                .selectAnyPayment()
                .clickPlaceOrder()
                .verifySuccessOrder(selectedPizza);
    }
}
