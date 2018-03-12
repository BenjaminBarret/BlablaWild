package fr.wcs.blablawild;

/**
 * Created by wilder on 12/03/18.
 */

public class VehicleCar extends VehicleAbstract {

    int kilometers;

    public VehicleCar (String model, String brand, int kilometers) {
        super(brand, model);
        this.kilometers = kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public String getDescription() {
        return String.format("%s %s %s",getModel(),getBrand(),getKilometers());
    }
}
