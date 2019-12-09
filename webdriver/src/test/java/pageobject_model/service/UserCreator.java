package pageobject_model.service;

import pageobject_model.model.User;

public class UserCreator {

    public static final String TEST_DATA_CASE1_USER_NAME = "baby-yoda";
    public static final String TEST_DATA_CASE1_USER_EMAIL = "mandalorianSuperCool@gmail.com";

    public static User withCredentialsFromProperty(){
        return new User(TEST_DATA_CASE1_USER_NAME, TEST_DATA_CASE1_USER_EMAIL);
    }

    public static User withEmptyUsername() { return new User("", TEST_DATA_CASE1_USER_EMAIL); }
    public static User withEmptyEmail() { return new User(TEST_DATA_CASE1_USER_NAME, ""); }
}
