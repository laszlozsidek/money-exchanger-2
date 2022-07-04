package com.zsidek.model;

public enum Currency {

    USD, EUR, GBP;

    public static Currency getCurrencyByName(String name) {
        for (Currency currency : Currency.values()) {
            if (currency.name().equals(name)) {
                return currency;
            }
        }
        return null;
    }

}