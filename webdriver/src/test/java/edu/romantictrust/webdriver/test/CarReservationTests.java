package edu.romantictrust.webdriver.test;

import edu.romantictrust.webdriver.model.CarReservation;
import edu.romantictrust.webdriver.page.ReservationPage;
import edu.romantictrust.webdriver.service.CarReservationCreator;
import org.testng.annotations.Test;

public class CarReservationTests extends CommonConditions{
    @Test(description = "A test for reproducing the catch of errors associated with incorrect date input. >> Test case №4 <<")
    public void ReservationDataTest() {
        CarReservation reservation = CarReservationCreator.withNormalCredentialsFromProperty();
        String expectedEmailConfirmationString = new ReservationPage(driver)
                .openPage()
                .setRentCarData(reservation).getPlaceholder();
    }
}
