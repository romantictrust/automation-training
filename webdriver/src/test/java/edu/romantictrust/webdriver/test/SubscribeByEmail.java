package edu.romantictrust.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import edu.romantictrust.webdriver.model.User;
import edu.romantictrust.webdriver.page.MainPage;
import edu.romantictrust.webdriver.service.UserCreator;


public class SubscribeByEmail extends CommonConditions {

    @Test (description = "A test for reproducing the catch of errors associated with incorrect email input. >> Test case №1 <<")
    public void SubscribeByEmailTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedEmailConfirmationString = new MainPage(driver)
                .openPage()
                .subscribeEmail(testUser).getPlaceholder();
        Assert.assertEquals(expectedEmailConfirmationString, "Invalid email");
    }
}
