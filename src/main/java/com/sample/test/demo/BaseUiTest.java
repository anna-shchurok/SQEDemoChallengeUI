package com.sample.test.demo;

import com.sample.test.demo.page_objects.PizzaOrderFormPage;
import org.testng.annotations.BeforeMethod;

public class BaseUiTest extends TestBase {
    protected ThreadLocal<PizzaOrderFormPage> pizzaPage = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        pizzaPage.set(new PizzaOrderFormPage(getDriver()));
    }

    protected PizzaOrderFormPage getPizzaOrderPage() {
        return pizzaPage.get();
    }
}
