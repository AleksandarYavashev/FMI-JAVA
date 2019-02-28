package bg.sofia.uni.fmi.mjt.carstore;

import bg.sofia.uni.fmi.mjt.carstore.car.Car;

public class DefaultComparator implements java.util.Comparator<Car>{

    @Override
    public int compare(Car car1, Car car2) {
        int byModel = car1.getModel().compareTo(car2.getModel());
        if(byModel == 0){
            return Integer.compare(car1.getYear(), car2.getYear());
        }

        return byModel;
    }
}
