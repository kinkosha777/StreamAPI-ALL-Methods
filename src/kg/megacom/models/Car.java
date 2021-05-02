package kg.megacom.models;

import kg.megacom.models.enums.CarType;
import kg.megacom.models.enums.ColorCar;

import java.util.Objects;

public class Car {

    private String name;
    private CarType carType;
    private ColorCar colorCar;
    private int price;


    public Car() {
    }

    public Car(String name, CarType carType, ColorCar colorCar, int price) {
        this.name = name;
        this.carType = carType;
        this.colorCar = colorCar;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public ColorCar getColorCar() {
        return colorCar;
    }

    public void setColorCar(ColorCar colorCar) {
        this.colorCar = colorCar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(name, car.name) && carType == car.carType && colorCar == car.colorCar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carType, colorCar, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carType=" + carType +
                ", colorCar=" + colorCar +
                ", price=" + price +
                '}';
    }


}
