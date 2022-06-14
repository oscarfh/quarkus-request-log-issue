package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.main.QuarkusMainLauncher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ApplicationMainIT {

	@Test
	public void myTest() {
		given()
				.when().get("/hello")
				.then()
				.statusCode(200);
	}
}
