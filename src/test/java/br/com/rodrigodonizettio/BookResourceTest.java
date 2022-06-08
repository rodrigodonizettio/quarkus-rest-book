package br.com.rodrigodonizettio;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
             .body(is("[{\"id\":1,\"isTranslated\":\"false\",\"numberOfPages\":272,\"title\":\"Essentialism\"}," +
                            "{\"id\":2,\"isTranslated\":\"false\",\"numberOfPages\":295,\"title\":\"The Hard Things About Hard Things\"}]"));
    }

    @Test
    public void countBooksTest() {
        given()
            .when().get("/book/count")
            .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    public void getBookByExistingIdTest() {
        given()
            .when().get("/book/2")
            .then()
                .statusCode(200)
                .body(is("{\"id\":2,\"isTranslated\":\"false\",\"numberOfPages\":295,\"title\":\"The Hard Things About Hard Things\"}"));
    }

    @Test
    public void getAnotherBookByExistingIdTest() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
        .when()
            .get("/book/{id}")
        .then()
            .statusCode(Response.Status.OK.getStatusCode())
            .body("id", is(1))
            .body("numberOfPages", is(272))
            .body("title", is("Essentialism"));
    }

    @Test
    public void getBookByNonexistentIdTest() {
        given()
                .when().get("/book/3")
                .then()
                .statusCode(200)
                .body(is("null"));
    }
}