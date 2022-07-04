package com.zsidek.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CurrencyUtil {

    public static String getSymbolStringFromSetOfCurrencies(Set<String> currencySet) {
        List<String> currencies = new ArrayList<>(currencySet);
        StringBuilder symbolString = new StringBuilder();
        for (String currency : currencies) {
            symbolString.append(currency);
            symbolString.append("HUF=X");
            if (currencies.indexOf(currency) != currencies.size() - 1) {
                symbolString.append(",");
            }
        }
        return symbolString.toString();
    }

}