package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public abstract class VehicleAbstract {

    String brand;
    String model;

    public VehicleAbstract(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract String getDescription();

}
