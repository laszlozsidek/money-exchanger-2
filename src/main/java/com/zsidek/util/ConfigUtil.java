package com.zsidek.util;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

@Slf4j
public class ConfigUtil {
    private static final String CONFIG_PATH_TEMPLATE = "src/main/resources/config.properties";
    private static Properties config;

    private ConfigUtil() {
    }

    public static Properties getConfig() {
        if (config == null) {
            config = new Properties();

            try (InputStream inputStream = new FileInputStream(CONFIG_PATH_TEMPLATE)) {
                config.load(inputStream);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return config;
    }

    public static String getBasePath() {
        return getConfig().getProperty("base_url");
    }

    public static String getApiKey() {
        return getConfig().getProperty("api_key");
    }

    public static RequestSpecification createRequestSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(getBasePath())
                .header("X-API-KEY", getApiKey())
                .log().method().log().uri().log().body();
    }
}
