package edu.romantictrust.webdriver.service;

import edu.romantictrust.webdriver.model.CarReservation;

public class CarReservationCreator {
    private static final String TEST_DATA_CASE4_PICKUP_COUNTRY = "testdata.case4.pickUpCountry";
    private static final String TEST_DATA_CASE4_PICKUP_CITY = "testdata.case4.pickUpCity";
    private static final String TEST_DATA_CASE4_PICKUP_LOCATION = "testdata.case4.pickUpLocation";
    private static final String TEST_DATA_CASE4_PICKUP_DATE = "testdata.case4.pickUpDate";
    private static final String TEST_DATA_CASE4_PICKUP_TIME = "testdata.case4.pickUpTime";
    private static final String TEST_DATA_CASE4_DROPOFF_DATE = "testdata.case4.dropOffDate";
    private static final String TEST_DATA_CASE4_DROPOFF_TIME= "testdata.case4.dropOffTime";


    public static CarReservation withNormalCredentialsFromProperty() {
        return new CarReservation(TestDataReader.getTestData(TEST_DATA_CASE4_PICKUP_COUNTRY),
                TestDataReader.getTestData(TEST_DATA_CASE4_PICKUP_CITY),
                TestDataReader.getTestData(TEST_DATA_CASE4_PICKUP_LOCATION),
                TestDataReader.getTestData(TEST_DATA_CASE4_PICKUP_DATE),
                TestDataReader.getTestData(TEST_DATA_CASE4_PICKUP_TIME),
                TestDataReader.getTestData(TEST_DATA_CASE4_DROPOFF_DATE),
                TestDataReader.getTestData(TEST_DATA_CASE4_DROPOFF_TIME));
    }
}
