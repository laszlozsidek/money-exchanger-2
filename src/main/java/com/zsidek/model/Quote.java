package com.zsidek.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String language;
    private String region;
    private String quoteType;
    @JsonProperty("typeDisp")
    private String typeDisplay;
    private String quoteSourceName;
    private Boolean triggerable;
    private String customPriceAlertConfidence;
    private String currency;
    private String marketState;
    private String exchange;
    private String shortName;
    private String longName;
    private String messageBoardId;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private Long gmtOffSetMilliseconds;
    private String market;
    private String esgPopulated;
    private String firstTradeDateMilliseconds;
    private Integer priceHint;
    private Float regularMarketChange;
    private Float regularMarketChangePercent;
    private Long regularMarketTime;
    private Float regularMarketPrice;
    private Float regularMarketDayHigh;
    private String regularMarketDayRange;
    private Float regularMarketDayLow;
    private Float regularMarketVolume;
    private Float regularMarketPreviousClose;
    private Float bid;
    private Float ask;
    private Float bidSize;
    private Float askSize;
    private String fullExchangeName;
    private Float regularMarketOpen;
    private Float averageDailyVolume3Month;
    private Float averageDailyVolume10Day;
    private Float fiftyTwoWeekLowChange;
    private Float fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private Float fiftyTwoWeekHighChange;
    private Float fiftyTwoWeekHighChangePercent;
    private Float fiftyTwoWeekLow;
    private Float fiftyTwoWeekHigh;
    private Float fiftyDayAverage;
    private Float fiftyDayAverageChange;
    private Float fiftyDayAverageChangePercent;
    private Float twoHundredDayAverage;
    private Float twoHundredDayAverageChange;
    private Float twoHundredDayAverageChangePercent;
    private Float sourceInterval;
    private Float exchangeDataDelayedBy;
    private Boolean tradeable;
    private String symbol;

}