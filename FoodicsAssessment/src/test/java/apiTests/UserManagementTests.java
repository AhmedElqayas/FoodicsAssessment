package apiTests;

import api.ExceptionHandling.UserManagementException;
import api.validations.UserManagementValidations;
import org.testng.annotations.Test;

public class UserManagementTests {

    @Test
    public void createUserTest() throws UserManagementException {
        UserManagementValidations.validateCreatingUser();
    }

    @Test
    public void getUserTest() throws UserManagementException {
        UserManagementValidations.validateGettingUser();
    }

    @Test
    public void updateUserTest() throws UserManagementException {
        UserManagementValidations.validateUpdatingUser();
    }
}
