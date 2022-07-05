package com.zsidek.logic;

import com.zsidek.controller.ProfitMaximizer;
import com.zsidek.model.Currency;
import com.zsidek.model.Quote;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class LogicalTests {

    @Test
    void testIfPercentageCalculationsIsOK() {
        Quote quote1 = Quote.builder().regularMarketPrice(0f).fiftyTwoWeekHigh(10000f).build();
        Quote quote2 = Quote.builder().regularMarketPrice(9999f).fiftyTwoWeekHigh(10000f).build();
        Quote quote3 = Quote.builder().regularMarketPrice(10000f).fiftyTwoWeekHigh(10000f).build();
        Quote quote4 = Quote.builder().regularMarketPrice(10001f).fiftyTwoWeekHigh(10000f).build();
        Quote quote5 = Quote.builder().regularMarketPrice(10100f).fiftyTwoWeekHigh(10000f).build();
        Quote quote6 = Quote.builder().regularMarketPrice(-9990f).fiftyTwoWeekHigh(10000f).build();
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote1)).isZero();
        log.info("Percentage calculation with zero is OK");
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote2)).isEqualTo(99.99f);
        log.info("Boundary percentage calculation 1 is OK");
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote3)).isEqualTo(100);
        log.info("Boundary percentage calculation 2 is OK");
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote4)).isEqualTo(100.01f);
        log.info("Boundary percentage calculation 3 is OK");
        Assertions.assertThat(ProfitMaximizer.getPercentage(quote5)).isEqualTo(101);
        log.info("Boundary percentage calculation 4 is OK");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> ProfitMaximizer.getPercentage(quote6));
        log.info("Boundary percentage calculation with negative number is OK");
    }

    @Test
    void testIfProfitMaximizerIsOK1() {
        Quote quote1 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(97f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.USD.name());
        log.info("Test of ProfitMaximizer1 is OK");
    }

    @Test
    void testIfProfitMaximizerIsOK2() {
        Quote quote1 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(103f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(102f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(100f).fiftyTwoWeekHigh(101f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.EUR.name());
        log.info("Test of ProfitMaximizer2 is OK");
    }

    @Test
    void testIfProfitMaximizerIsOK3() {
        Quote quote1 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.GBP.name());
        log.info("Test of ProfitMaximizer3 is OK");
    }

    @Test
    void testIfProfitMaximizerIsOK4() {
        Quote quote1 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("USD").build();
        Quote quote2 = Quote.builder().regularMarketPrice(98f).fiftyTwoWeekHigh(100f).shortName("GBP").build();
        Quote quote3 = Quote.builder().regularMarketPrice(99f).fiftyTwoWeekHigh(100f).shortName("EUR").build();
        String currency = ProfitMaximizer.sellToMaximizeProfit(List.of(quote1, quote2, quote3));
        Assertions.assertThat(currency).isEqualTo(Currency.EUR.name());
        log.info("Test of ProfitMaximizer4 is OK");
    }

}