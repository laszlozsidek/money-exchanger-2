package com.zsidek.service;

import com.zsidek.model.Quote;
import com.zsidek.util.ConfigUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FinanceService {

    private static final String GET_QUOTE = "/v6/finance/quote";
    private static final String REGION = "region";
    private static final String DE = "DE";
    private static final String LANG = "lang";
    private static final String EN = "en";
    private static final String SYMBOLS = "symbols";
    private static final String HUF = "HUF=X";
    private static final String EUR_HUF = "EUR" + HUF;
    private static final String USD_HUF = "USD" + HUF;
    private static final String GBP_HUF = "GBP" + HUF;
    private static final String SYMBOLS_WITH_3_CURRENCIES = "%s,%s,%s";

    public List<Quote> getQuotes(String symbols) {
        return getResponseOfQuoteEndpoint(symbols)
                .then()
                .log().status()
                .log().body()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getList("quoteResponse.result", Quote.class);
    }

    public Response getResponseOfQuoteEndpoint() {
        return given()
                .spec(ConfigUtil.createRequestSpec())
                .queryParams(
                        REGION, DE,
                        LANG, EN,
                        SYMBOLS, String.format(SYMBOLS_WITH_3_CURRENCIES, EUR_HUF, USD_HUF, GBP_HUF)
                )
                .when()
                .get(GET_QUOTE);
    }

    public Response getResponseOfQuoteEndpoint(String symbols) {
        return given()
                .spec(ConfigUtil.createRequestSpec())
                .queryParams(
                        REGION, DE,
                        LANG, EN,
                        SYMBOLS, symbols
                )
                .when()
                .get(GET_QUOTE);
    }

}