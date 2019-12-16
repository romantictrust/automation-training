package pageobject_model.service;

import pageobject_model.model.User;

public class UserCreator {

    public static final String TEST_DATA_CASE1_USER_NAME = "testdata.user.name";
    public static final String TEST_DATA_CASE1_USER_EMAIL = "testdata.user.email";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TEST_DATA_CASE1_USER_NAME),
                TestDataReader.getTestData(TEST_DATA_CASE1_USER_EMAIL));
    }

    public static User withEmptyUsername() { return new User("", TestDataReader.getTestData(TEST_DATA_CASE1_USER_EMAIL)); }
    public static User withEmptyEmail() { return new User(TestDataReader.getTestData(TEST_DATA_CASE1_USER_NAME), ""); }
}
