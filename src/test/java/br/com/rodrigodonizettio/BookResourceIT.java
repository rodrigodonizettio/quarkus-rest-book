package br.com.rodrigodonizettio;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in native mode.

    // mvn verify -Pnative (it'll execute mvn test, then will build a native app and then run tests against the binary)
    // The binary is built under %prod profile, so some tests may be overridden to match your application.profile configs.

    @Test
    public void getAllBooksTest() {
        given()
                .when().get("/book")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"isTranslated\":\"true\",\"numberOfPages\":272,\"title\":\"Essentialism\"}," +
                        "{\"id\":2,\"isTranslated\":\"true\",\"numberOfPages\":295,\"title\":\"The Hard Things About Hard Things\"}]"));
    }

    @Test
    public void getBookByExistingIdTest() {
        given()
                .when().get("/book/2")
                .then()
                .statusCode(200)
                .body(is("{\"id\":2,\"isTranslated\":\"true\",\"numberOfPages\":295,\"title\":\"The Hard Things About Hard Things\"}"));
    }
}
