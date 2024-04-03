package br.com.placeholder.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import br.com.placeholder.Utils.ReportManager;
import br.com.placeholder.Utils.Utils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.JSONObject;

public class AppTest {

    @BeforeClass
    public static void setUp() {
        ReportManager.init("report.html");
    }
    @Test
    public void testPostRandomUserData() {
        ReportManager.createTest("test Post Random User Data");
        String requestBody = br.com.placeholder.Data.RandomDataGenerator.generateRandomUserRequestBody();
        JSONObject requestBodyJson = new JSONObject(requestBody);
        String postEndpoint = Utils.BASE_URI + Utils.USERS_ENDPOINT;

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post(postEndpoint)
        .then()
            .statusCode(201)
            .body("name", equalTo(requestBodyJson.getString("name")))
            .body("username", equalTo(requestBodyJson.getString("username")))
            .body("email", equalTo(requestBodyJson.getString("email")))
            .body("address.street", equalTo(requestBodyJson.getJSONObject("address").getString("street")))
            .body("address.suite", equalTo(requestBodyJson.getJSONObject("address").getString("suite")))
            .body("address.city", equalTo(requestBodyJson.getJSONObject("address").getString("city")))
            .body("address.zipcode", equalTo(requestBodyJson.getJSONObject("address").getString("zipcode")))
            .body("address.geo.lat", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lat")))
            .body("address.geo.lng", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lng")))
            .body("phone", equalTo(requestBodyJson.getString("phone")))
            .body("website", equalTo(requestBodyJson.getString("website")))
            .body("company.name", equalTo(requestBodyJson.getJSONObject("company").getString("name")))
            .body("company.catchPhrase", equalTo(requestBodyJson.getJSONObject("company").getString("catchPhrase")))
            .body("company.bs", equalTo(requestBodyJson.getJSONObject("company").getString("bs")));

            ReportManager.getTest().pass("Test passed");
    }

    @Test
    public void testPutStaticData() {
      
        ReportManager.createTest("test Put Static Data");
        String putJsonData = br.com.placeholder.Data.StaticJsonData.generatePutJsonData(); 
        JSONObject requestBodyJson = new JSONObject(putJsonData);
        int id = requestBodyJson.getInt("id");
        String putEndpoint = Utils.BASE_URI + Utils.USERS_ENDPOINT + "/" + id;

        given()
            .contentType("application/json")
            .body(putJsonData)
        .when()
            .put(putEndpoint)
        .then()
        .statusCode(200)
        .body("name", equalTo(requestBodyJson.getString("name")))
        .body("username", equalTo(requestBodyJson.getString("username")))
        .body("email", equalTo(requestBodyJson.getString("email")))
        .body("address.street", equalTo(requestBodyJson.getJSONObject("address").getString("street")))
        .body("address.suite", equalTo(requestBodyJson.getJSONObject("address").getString("suite")))
        .body("address.city", equalTo(requestBodyJson.getJSONObject("address").getString("city")))
        .body("address.zipcode", equalTo(requestBodyJson.getJSONObject("address").getString("zipcode")))
        .body("address.geo.lat", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lat")))
        .body("address.geo.lng", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lng")))
        .body("phone", equalTo(requestBodyJson.getString("phone")))
        .body("website", equalTo(requestBodyJson.getString("website")))
        .body("company.name", equalTo(requestBodyJson.getJSONObject("company").getString("name")))
        .body("company.catchPhrase", equalTo(requestBodyJson.getJSONObject("company").getString("catchPhrase")))
        .body("company.bs", equalTo(requestBodyJson.getJSONObject("company").getString("bs")));

        ReportManager.getTest().pass("Test passed");
    }

    @Test
    public void testGetStaticData() {
      
        ReportManager.createTest("test Get Static Data");
        String getJsonData = br.com.placeholder.Data.StaticJsonData.generateGetJsonData(); 
        JSONObject requestBodyJson = new JSONObject(getJsonData);
        int id = requestBodyJson.getInt("id");
        String putEndpoint = Utils.BASE_URI + Utils.USERS_ENDPOINT + "/" + id;

        given()
            .contentType("application/json")
        .when()
            .get(putEndpoint)
        .then()
        .statusCode(200)
        .body("name", equalTo(requestBodyJson.getString("name")))
        .body("username", equalTo(requestBodyJson.getString("username")))
        .body("email", equalTo(requestBodyJson.getString("email")))
        .body("address.street", equalTo(requestBodyJson.getJSONObject("address").getString("street")))
        .body("address.suite", equalTo(requestBodyJson.getJSONObject("address").getString("suite")))
        .body("address.city", equalTo(requestBodyJson.getJSONObject("address").getString("city")))
        .body("address.zipcode", equalTo(requestBodyJson.getJSONObject("address").getString("zipcode")))
        .body("address.geo.lat", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lat")))
        .body("address.geo.lng", equalTo(requestBodyJson.getJSONObject("address").getJSONObject("geo").getString("lng")))
        .body("phone", equalTo(requestBodyJson.getString("phone")))
        .body("website", equalTo(requestBodyJson.getString("website")))
        .body("company.name", equalTo(requestBodyJson.getJSONObject("company").getString("name")))
        .body("company.catchPhrase", equalTo(requestBodyJson.getJSONObject("company").getString("catchPhrase")))
        .body("company.bs", equalTo(requestBodyJson.getJSONObject("company").getString("bs")));

        ReportManager.getTest().pass("Test passed");
    }

    @Test
    public void testDeleteStaticData() {
      
        ReportManager.createTest("test Delete Static Data");
        String deleteJsonData = br.com.placeholder.Data.StaticJsonData.generateDeleteJsonData(); 
        JSONObject requestBodyJson = new JSONObject(deleteJsonData);
        int id = requestBodyJson.getInt("id");
        String deleteEndpoint = Utils.BASE_URI + Utils.USERS_ENDPOINT + "/" + id;

        given()
            .contentType("application/json")
        .when()
            .delete(deleteEndpoint)
        .then()
        .statusCode(200);

        ReportManager.getTest().pass("Test passed");
    }

    @AfterClass
    public static void tearDown() {
        // Finaliza e gera o relatório
        ReportManager.flush();
    }
}


