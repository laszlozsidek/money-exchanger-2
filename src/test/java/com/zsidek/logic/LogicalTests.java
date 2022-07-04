package com.zsidek.logic;

import com.zsidek.controller.ProfitMaximizer;
import com.zsidek.model.Currency;
import com.zsidek.model.Quote;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LogicalTests {

    @Test
    void testIfPercentageCalculationsIsOK() {
        Quote quote1 = Quote.builder().regularMarketPrice(0f).fiftyTwoWeekHigh(10000f).build();
        Quote quote2 = Quote.builder().regularMarketPrice(9999f).fiftyTwoWeekHigh(10000f).build();
        Quote quote3 = Quote.builder().regularMarketPrice(10000f).fiftyTwoWeekHigh(10000f).build();
        Quote quote4 = Quote.builder().regularMarketPrice(10001f).fiftyTwoWeekHigh(10000f).build();
        Quote quote5 = Quote.builder().regularMarketPrice(10100f).fiftyTwoWeekHigh(10000f).build();
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote1)).isZero();
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote2)).isEqualTo(99.99f);
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote3)).isEqualTo(100);
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote4)).isEqualTo(100.01f);
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote5)).isEqualTo(101);
    }

    @Test
    void testIfProfitMaximizerIsOK1() {
        Quote quote1 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(97f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.USD.name());
    }

    @Test
    void testIfProfitMaximizerIsOK2() {
        Quote quote1 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(103f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(102f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(101f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.EUR.name());
    }

    @Test
    void testIfProfitMaximizerIsOK3() {
        Quote quote1 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.GBP.name());
    }

    @Test
    void testIfProfitMaximizerIsOK4() {
        Quote quote1 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.EUR.name());
    }

}