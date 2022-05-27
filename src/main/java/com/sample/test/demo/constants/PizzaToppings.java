package com.sample.test.demo.constants;


import java.util.Arrays;

public enum PizzaToppings {
    MANGOS("Diced Mango"),
    OLIVES("Olives"),
    MUSHROOMS("Mushrooms"),
    ONIONS("Caramelized onions"),
    ITALIANHAM("Italian Ham"),
    PEPPERONI("Classic Pepperoni"),
    SALAMI("Salami"),
    PROVOLNE("Provolone cheese"),
    EXTRACHEESE("Extra cheese"),
    MOZZARELLA("Mozzarella cheese"),
    PARMASAN("Parmesan cheese");

    private String displayName;

    public static PizzaToppings getPizzaToppingByName(String name) {
        return Arrays.stream(values()).filter(p -> name.contains(p.displayName)).findAny()
                .orElseThrow(() -> new IllegalArgumentException("No pizza topping found with name: " + name));
    }

    PizzaToppings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
