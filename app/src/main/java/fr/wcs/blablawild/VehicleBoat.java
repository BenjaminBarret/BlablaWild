package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleBoat extends VehicleAbstract {

    int hours;

    public VehicleBoat(String model, String brand, int hours) {
        super(brand, model);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String getDescription() {
        return String.format("%s %s %s",getModel(),getBrand(), getHours());
    }
}
