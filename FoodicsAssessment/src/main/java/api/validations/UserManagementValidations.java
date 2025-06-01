package api.validations;

import api.ExceptionHandling.UserManagementException;
import api.responseBody.CreateUserResponseBody;
import api.responseBody.GetUserResponseBody;
import io.restassured.response.Response;
import org.testng.Assert;

import static api.requests.UserManagementRequests.*;

public class UserManagementValidations {
    public static void validateCreatingUser() throws UserManagementException {
        Response response = createUser();
        if (validateStatusCode(response, "post"))
            validateBody(response, "post");
    }

    public static void validateGettingUser() throws UserManagementException {
        Response response = getUser();
        if (validateStatusCode(response, "get"))
            validateBody(response, "get");
    }

    public static void validateUpdatingUser() throws UserManagementException {
        Response response = updateUser();
        if (validateStatusCode(response, "put"))
            validateBody(response, "put");
    }

    private static boolean validateStatusCode(Response response, String method) throws UserManagementException {
        int statusCode = response.getStatusCode();

        if (statusCode >= 400 && statusCode < 500)
            throw new UserManagementException("Invalid request");
        else if (statusCode >= 500)
            throw new UserManagementException("Server error");
        else {
            if (method.equalsIgnoreCase("post"))
                Assert.assertEquals(statusCode, 201);
            else
                Assert.assertEquals(statusCode, 200);
        }
        return true;
    }

    private static void validateBody(Response response, String method) {
        if (method.equalsIgnoreCase("get")) {
            getUserResponseBody = response.as(GetUserResponseBody.class);
            Assert.assertEquals(getUserResponseBody.data.first_name, createUserResponseBody.first_name);
            Assert.assertEquals(getUserResponseBody.data.last_name, createUserResponseBody.last_name);
            Assert.assertEquals(getUserResponseBody.data.job, createUserResponseBody.job);
        } else if (method.equalsIgnoreCase("post")){
            createUserResponseBody = response.as(CreateUserResponseBody.class);
            Assert.assertEquals(createUserRequestBody.first_name, createUserResponseBody.first_name);
            Assert.assertEquals(createUserRequestBody.last_name, createUserResponseBody.last_name);
            Assert.assertEquals(createUserRequestBody.job, createUserResponseBody.job);
        } else if (method.equalsIgnoreCase("put")) {
            updateUserResponseBody = response.as(CreateUserResponseBody.class);
            Assert.assertEquals(updateUserRequestBody.first_name, updateUserResponseBody.first_name);
            Assert.assertEquals(updateUserRequestBody.last_name, updateUserResponseBody.last_name);
            Assert.assertEquals(updateUserRequestBody.job, updateUserResponseBody.job);
        }
    }

}
