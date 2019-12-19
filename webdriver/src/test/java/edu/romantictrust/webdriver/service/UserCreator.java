package edu.romantictrust.webdriver.service;

import edu.romantictrust.webdriver.model.User;

public class UserCreator {

    public static final String TEST_DATA_CASE1_USER_NAME = "testdata.user.name";
    public static final String TEST_DATA_CASE1_USER_EMAIL = "testdata.user.email";

    public static final String TEST_DATA_CASE7_USER_EMAIL = "testdata.case7.user.email";
    public static final String TEST_DATA_CASE7_USER_PASSWORD = "testdata.case7.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TEST_DATA_CASE1_USER_NAME),
                TestDataReader.getTestData(TEST_DATA_CASE1_USER_EMAIL));
    }

    public static User withEmptyAgeAndUsername(){
        return new User("", TestDataReader.getTestData(TEST_DATA_CASE7_USER_EMAIL), "",
                TestDataReader.getTestData(TEST_DATA_CASE7_USER_PASSWORD));
    }

    public static User withEmptyUsername() { return new User("", TestDataReader.getTestData(TEST_DATA_CASE1_USER_EMAIL)); }
    public static User withEmptyEmail() { return new User(TestDataReader.getTestData(TEST_DATA_CASE1_USER_NAME), ""); }
}
