package edu.romantictrust.webdriver.test;

import edu.romantictrust.webdriver.model.User;
import edu.romantictrust.webdriver.page.AuthorizationPage;
import edu.romantictrust.webdriver.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationPageTests extends CommonConditions {
    @Test(description = "A test for reproducing the catch of errors associated with incorrect conditionals enter. >> Test case №7 <<")
    public void Authorize() {
        User testUser = UserCreator.withEmptyAgeAndUsername();
        String expectedEmailConfirmationString = new AuthorizationPage(driver)
                .openPage()
                .signIn(testUser).getPlaceholder();
        Assert.assertEquals(expectedEmailConfirmationString, "PLEASE ENTER A VALID EMAIL AND PASSWORD.");
    }
}
