package com.zsidek.controller;

import com.zsidek.model.Quote;

import java.util.List;

public class ProfitMaximizer {

    private ProfitMaximizer() {
    }

    public static String sellToMaximizeProfit(List<Quote> quotes) {
        float max = 0f;
        String currency = "";
        for (Quote quote : quotes) {
            float newMax = Math.max(max, getPercentage(quote));
            if (max != newMax) {
                currency = getCurrencyFromQuote(quote);
                max = newMax;
            }
        }
        return currency;
    }

    public static Float getPercentage(Quote quote) {
        return quote.getRegularMarketPrice() * 100 / quote.getFiftyTwoWeekHigh();
    }

    private static String getCurrencyFromQuote(Quote quote) {
        return quote.getShortName().substring(0, 3);
    }

}