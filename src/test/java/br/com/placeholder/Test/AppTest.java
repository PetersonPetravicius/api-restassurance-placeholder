package br.com.placeholder.Test;
import org.testng.annotations.Test;
import br.com.placeholder.Utils.Utils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import org.json.JSONObject;

public class AppTest {
    @Test
    public void testPostRandomUserData() {

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
    }
    @Test
    public void testPutStaticData() {
      
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
    }
    @Test
    public void testGetStaticData() {
      
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
    }
    @Test
    public void testDeleteStaticData() {
      
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
    }
}


