package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.AuthorizationRequestBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoreTest {
    public final String STORES_URL = "https://dairy.intrtl.tech/api/v1/stores/";
    public final String TOKEN_URL = "https://dairy.intrtl.tech/api/v1/auth/login";
    public String authorizationToken;
    public RequestSpecification requestSpecification;
    public Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    @BeforeAll
    public void setUp() {
        authorizationToken =  RestAssured
                .given()
                .body(new AuthorizationRequestBody("testlogin123", "testlogin123"))
                .when()
                .post(TOKEN_URL)
                .body()
                .jsonPath()
                .getString("token");

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + authorizationToken)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

    }

}
