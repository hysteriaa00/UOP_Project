/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Model;


public class Car {
    
    private String model;
    private String manufacturer;
    private String manufacturerYear;
    private String registration;
    private Long taxiNumber;
    private CarType carType;
    private Driver driver;
    
    
    
    
    
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerYear() {
        return manufacturerYear;
    }

    public void setManufacturerYear(String manufacturerYear) {
        this.manufacturerYear = manufacturerYear;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Long getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(Long taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
