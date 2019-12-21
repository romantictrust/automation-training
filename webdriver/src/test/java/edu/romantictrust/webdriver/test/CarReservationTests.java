package edu.romantictrust.webdriver.test;

import edu.romantictrust.webdriver.model.CarReservation;
import edu.romantictrust.webdriver.page.ReservationPage;
import edu.romantictrust.webdriver.service.CarReservationCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarReservationTests extends CommonConditions{
    @Test(description = "A test for reproducing the catch of errors associated with incorrect date input. >> Test case №4 <<")
    public void ReservationDataTest() {
        CarReservation reservation = CarReservationCreator.withNormalCredentialsFromProperty();
        String expectedCarReservationDate = new ReservationPage(driver)
                .openPage()
                .setCountry(reservation)
                .setCity(reservation)
                .setLocation(reservation)
                .setPUdate(reservation)
                .setPUtime(reservation)
                .setDOdate(reservation)
                .setDOtime(reservation)
                .runCarReservation(reservation)
                .getPlaceholder();
        Assert.assertEquals(expectedCarReservationDate, "19 JAN 2020");
    }

    @Test(description = "A test for reproducing the display of cars with necessary transmission caused by clicking on the type. >> Test case №6 <<")
    public void CheckTransmissionTypeTest() {
        CarReservation reservation = CarReservationCreator.withNormalCredentialsFromProperty();
        String expectedStringWhenChangeTransmissionType = new ReservationPage(driver)
                .openPage()
                .setCountry(reservation)
                .setCity(reservation)
                .setLocation(reservation)
                .setPUdate(reservation)
                .setPUtime(reservation)
                .setDOdate(reservation)
                .setDOtime(reservation)
                .runCarReservation(reservation)
                .changeTransmission()
                .getChangedTransmission();
        Assert.assertEquals(expectedStringWhenChangeTransmissionType, "--");
    }
}
