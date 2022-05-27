package com.sample.test.demo.tests.exercise;

import com.sample.test.demo.BaseUiTest;
import com.sample.test.demo.constants.TestGroups;
import com.sample.test.demo.helpers.Randomizer;
import org.testng.annotations.Test;

import static com.sample.test.demo.page_objects.BasePage.verify;

public class QuantityFieldValidation extends BaseUiTest {

    @Test(groups = {TestGroups.BOUNDARY, TestGroups.NEGATIVE},
            description = "NEGATIVE - BOUNDARY - QUANTITY FIELD VALIDATION")
    public void validateQuantityField() {
        verify(getPizzaOrderPage()).updateQuantity(-5)
                .verifyValueOfQuantity(5)
                .updateQuantity(123456)
                .verifyValueOfQuantity(12345)
                .updateQuantity(Randomizer.randomStringChars(5))
                .verifyValueOfQuantity("")
                .updateQuantity(Randomizer.randomSpecialCharacters(5))
                .verifyValueOfQuantity("");
    }
}
