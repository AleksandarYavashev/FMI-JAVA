package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;

public abstract class Car {

    public Car(Model model, int year, int price, EngineType engineType, Region region){
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.registrationNumber = region.getRegNumber();
    }

    /**
     * Returns the model of the car.
     */
    public  Model getModel(){
        return model;
    }

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear(){
        return year;
    }

    /**
     * Returns the price of the car.
     */
    public  int getPrice(){ return price; }

    /**
     * Returns the engine type of the car.
     */
    public  EngineType getEngineType(){
        return engineType;
    }

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    private Model model;
    private EngineType engineType;
    private String registrationNumber;
    private int year;
    private int price;
}
