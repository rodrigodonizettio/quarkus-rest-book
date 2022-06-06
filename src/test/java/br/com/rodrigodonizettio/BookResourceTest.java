package br.com.rodrigodonizettio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {
    @Test
    public void getAllBooksTest() {
        given()
          .when().get("/book")
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"numberOfPages\":272,\"title\":\"Essentialism\"}," +
                            "{\"id\":2,\"numberOfPages\":295,\"title\":\"The Hard Things About Hard Things\"}]"));
    }

    @Test
    public void countBooksTest() {
        given()
            .when().get("/book/count")
            .then()
                .statusCode(200)
                .body(is("2"));
    }

}