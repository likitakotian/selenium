package api.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
public class GetTest {

	
	@Test
	public void getTest() {
		given()
		.when()
			.get("")
		.then()
			.statusCode(200);
	}
}
