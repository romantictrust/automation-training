package edu.romantictrust.webdriver.model;

import java.util.Objects;

public class CarReservation {
    private String pickUpCountry;
    private String pickUpCity;
    private String pickUpLocation;
    private String pickUpDate;
    private String pickUpTime;
    private String dropOffDate;
    private String dropOffTime;

    public CarReservation(String pickUpCountry, String pickUpCity, String pickUpLocation, String pickUpDate, String pickUpTime, String dropOffDate, String dropOffTime) {
        this.pickUpCountry = pickUpCountry;
        this.pickUpCity = pickUpCity;
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.dropOffDate = dropOffDate;
        this.dropOffTime = dropOffTime;
    }

    public String getPickUpCountry() {
        return pickUpCountry;
    }

    public String getPickUpCity() {
        return pickUpCity;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpCountry(String pickUpCountry) {
        this.pickUpCountry = pickUpCountry;
    }

    public void setPickUpCity(String pickUpCity) {
        this.pickUpCity = pickUpCity;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    @Override
    public String toString() {
        return "CarReservation{" +
                "pickUpCountry='" + pickUpCountry + '\'' +
                ", pickUpCity='" + pickUpCity + '\'' +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", pickUpTime='" + pickUpTime + '\'' +
                ", dropOffDate='" + dropOffDate + '\'' +
                ", dropOffTime='" + dropOffTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarReservation)) return false;
        CarReservation that = (CarReservation) o;
        return Objects.equals(getPickUpCountry(), that.getPickUpCountry()) &&
                Objects.equals(getPickUpCity(), that.getPickUpCity()) &&
                Objects.equals(getPickUpLocation(), that.getPickUpLocation()) &&
                Objects.equals(getPickUpDate(), that.getPickUpDate()) &&
                Objects.equals(getPickUpTime(), that.getPickUpTime()) &&
                Objects.equals(getDropOffDate(), that.getDropOffDate()) &&
                Objects.equals(getDropOffTime(), that.getDropOffTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPickUpCountry(), getPickUpCity(), getPickUpLocation(), getPickUpDate(), getPickUpTime(), getDropOffDate(), getDropOffTime());
    }
}
