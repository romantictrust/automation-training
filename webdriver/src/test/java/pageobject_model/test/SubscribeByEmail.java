package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.model.User;
import pageobject_model.page.MainPage;
import pageobject_model.service.UserCreator;


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
