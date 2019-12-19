package edu.romantictrust.webdriver.test;

import edu.romantictrust.webdriver.model.User;
import edu.romantictrust.webdriver.page.MotorHomePage;
import edu.romantictrust.webdriver.service.MotorHomeCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MotorHomePageTests extends CommonConditions {
    @Test(description = "A test for reproducing the catch of errors associated with incorrect age enter. >> Test case №2 <<")
    public void EnterAge() {
        User testUser = MotorHomeCreator.withCredentialsFromProperty();
        String expectedAgeConfirmationString = new MotorHomePage(driver)
                .openPage()
                .setUsersAge(testUser).getErrorPopupMessage();
        Assert.assertEquals(expectedAgeConfirmationString, "Sorry, no results were found for your search, please try a new search.");
    }
}
