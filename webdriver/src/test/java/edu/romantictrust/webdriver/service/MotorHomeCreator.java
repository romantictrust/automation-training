package edu.romantictrust.webdriver.service;

import edu.romantictrust.webdriver.model.User;

public class MotorHomeCreator {
    public static final String TEST_DATA_CASE2_USER_AGE = "testdata.user.age";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TEST_DATA_CASE2_USER_AGE));
    }
}
