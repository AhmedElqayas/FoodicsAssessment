package api.requests;

import api.requestBody.CreateUserRequestBody;
import api.responseBody.CreateUserResponseBody;
import api.responseBody.GetUserResponseBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.utils.PropertiesUtils;

import static io.restassured.RestAssured.given;

public class UserManagementRequests {
    private final static String baseUrl;
    private final static String headerKey;
    private final static String headerValue;
    public static CreateUserRequestBody createUserRequestBody;
    public static CreateUserResponseBody createUserResponseBody;
    public static GetUserResponseBody getUserResponseBody;
    public static CreateUserRequestBody updateUserRequestBody;
    public static CreateUserResponseBody updateUserResponseBody;

    static {
        baseUrl = PropertiesUtils.readProperty("baseUrl");
        headerKey = PropertiesUtils.readProperty("headerKey");
        headerValue = PropertiesUtils.readProperty("headerValue");
        createUserRequestBody = null;
        createUserResponseBody = null;
        getUserResponseBody = null;
        updateUserRequestBody = null;
        updateUserResponseBody = null;
    }


    public static CreateUserResponseBody getCreateUserResponseBody() {
        if (createUserResponseBody == null)
            createUserResponseBody = createUser().as(CreateUserResponseBody.class);
        return createUserResponseBody;
    }

    public static Response createUser() {
        createUserRequestBody = new CreateUserRequestBody("darrel", "george", "QA Analyst");

        return given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .contentType(ContentType.JSON)
                .body(createUserRequestBody)
                .when()
                .post("/api/users")
                .then()
                .extract()
                .response();
    }

    public static Response getUser() {

        return given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/" + getCreateUserResponseBody().id)
                .then()
                .extract()
                .response();
    }

    public static Response updateUser() {
        updateUserRequestBody = new CreateUserRequestBody("darrel", "george", "Scrum Master");

        return given()
                .baseUri(baseUrl)
                .header(headerKey, headerValue)
                .contentType(ContentType.JSON)
                .body(updateUserRequestBody)
                .when()
                .put("/api/users/" + getCreateUserResponseBody().id)
                .then()
                .extract()
                .response();
    }

}
