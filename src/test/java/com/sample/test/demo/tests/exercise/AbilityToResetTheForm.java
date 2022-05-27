package com.sample.test.demo.tests.exercise;

import com.sample.test.demo.BaseUiTest;
import com.sample.test.demo.constants.TestGroups;
import org.testng.annotations.Test;

import static com.sample.test.demo.page_objects.BasePage.verify;

public class AbilityToResetTheForm extends BaseUiTest {

    @Test(groups = {TestGroups.HAPPY_PATH},
            description = "HAPPY PATH - ABILITY TO RESET THE FORM")
    public void resetForm() {
        verify(getPizzaOrderPage()).selectAnyPizza();
        getPizzaOrderPage().selectAnyTopping1();
        getPizzaOrderPage().selectAnyTopping2();
        getPizzaOrderPage().updateQuantity(1)
                .fillNameWithAnyString()
                .fillEmailWithAnyEmail()
                .fillPhoneWithAnyNumbers()
                .selectAnyPayment()
                .clickReset()
                .verifyDefaultFormView();
    }
}
