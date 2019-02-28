package bg.sofia.uni.fmi.mjt.carstore.car;

import bg.sofia.uni.fmi.mjt.carstore.enums.EngineType;
import bg.sofia.uni.fmi.mjt.carstore.enums.Model;
import bg.sofia.uni.fmi.mjt.carstore.enums.Region;

public class OrdinaryCar extends Car {

    public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region){
        super(model, year, price, engineType, region);
    }
}
