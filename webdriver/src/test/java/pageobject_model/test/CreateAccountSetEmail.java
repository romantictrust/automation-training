package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.model.User;
import pageobject_model.page.CreateAccountPage;
import pageobject_model.service.UserCreator;

public class CreateAccountSetEmail extends CommonConditions {

    @Test(description = "A test for reproducing the catch of errors associated with email and verify email inconsistency. >> Test case №3 <<")
    public void CreateAccountSetEmailTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedErrorMessage = new CreateAccountPage(driver)
                .openPage()
                .moveToForm()
                .typeEmails(testUser).getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, "Your email and verify email addresses do not match.");
    }
}
