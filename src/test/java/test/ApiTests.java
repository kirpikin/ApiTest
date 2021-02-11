package test;

import io.restassured.RestAssured;
import model.StoresResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTests extends CoreTest {

    @Test
    public void testDefaultLimit() {
        //  Тест проверяет, что по умолчанию параметр лимит = 100 и нам приходит 100 обьектов в массиве data

        StoresResponse response = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get(STORES_URL)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(StoresResponse.class);


        Assertions.assertEquals(response.getLimit(), 100);
        Assertions.assertEquals(response.getData().size(), 100);

    }

    @Test
    public void testMinimumLimit() {
        //  Тест проверяет, что если установить лимит = 0 нам будет приходить пустой массив data

        StoresResponse response = RestAssured
                .given()
                .spec(requestSpecification)
                .queryParam("limit", 0)
                .when()
                .get(STORES_URL)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(StoresResponse.class);

        Assertions.assertEquals(0, response.getLimit());
        Assertions.assertEquals(0, response.getData().size());

    }

    @Test
    public void testMaximumLimit() {
        //  Тест проверяет, что если установить лимит = 10000 (Число взяд для примера. На самом деле не известно максимальное ограничение,
        //  его нужно уточнить) нам будет приходить в массиве data 10000 обьектов

        StoresResponse response = RestAssured
                .given()
                .spec(requestSpecification)
                .queryParam("limit", 10000)
                .when()
                .get(STORES_URL)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(StoresResponse.class);

        Assertions.assertEquals(10000, response.getLimit());
        Assertions.assertEquals(10000, response.getData().size());

    }

    @Test
    public void testNoTotal() {
        //  Тест проверяет, что если установить параметр no_total=true то не будет вестись подсчет количества результатов

        StoresResponse response = RestAssured
                .given()
                .spec(requestSpecification)
                .queryParam("no_total", true)
                .when()
                .get(STORES_URL)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(StoresResponse.class);


        Assertions.assertEquals(100, response.getLimit());
        Assertions.assertEquals(100, response.getData().size());
        Assertions.assertEquals(0, response.getTotal());

    }

    @Test
    public void testSetStoreTypeId() {
        //  Тест проверяет, что если установить параметр store_type_id то в ответе будут только эти результаты

        StoresResponse response = RestAssured
                .given()
                .spec(requestSpecification)
                .queryParam("store_type_id", 27)
                .when()
                .get(STORES_URL)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(StoresResponse.class);


        Assertions.assertEquals(100, response.getLimit());
        Assertions.assertEquals(100, response.getData().size());

        for (StoresResponse.Data data : response.getData()) {
            Assertions.assertEquals("27", data.getStore_type_id());
        }

    }
}
