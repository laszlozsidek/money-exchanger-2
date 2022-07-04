package com.zsidek.application;

import com.zsidek.controller.ProfitMaximizer;
import com.zsidek.model.Currency;
import com.zsidek.service.FinanceService;
import com.zsidek.util.CurrencyUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Exchanger {

    public static void main(String[] args) {
        Map<String, String> environmentVariables = System.getenv();
        Set<String> currencies = new HashSet<>();
        environmentVariables.keySet().stream().filter(e -> e.contains("ME2_CUR")).forEach(e -> currencies.add(environmentVariables.get(e)));
        log.info("Currencies from input: {}", currencies);

        for (Currency currency : Currency.values()) {
            currencies.add(currency.name());
        }
        log.info("All currencies to check: {}", currencies);

        FinanceService financeService = new FinanceService();
        String currency = ProfitMaximizer.sellToMaximizeProfit(financeService.getQuotes(CurrencyUtil.getSymbolStringFromSetOfCurrencies(currencies)));

        log.warn("We should sell our >> {} << to HUF", currency);
    }

}