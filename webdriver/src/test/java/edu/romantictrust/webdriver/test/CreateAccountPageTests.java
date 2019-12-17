package edu.romantictrust.webdriver.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import edu.romantictrust.webdriver.model.User;
import edu.romantictrust.webdriver.page.CreateAccountPage;
import edu.romantictrust.webdriver.service.UserCreator;

public class CreateAccountPageTests extends CommonConditions {

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
