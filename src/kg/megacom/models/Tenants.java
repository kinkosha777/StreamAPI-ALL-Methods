package kg.megacom.models;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

public class Tenants {

    private String name;
    private int age;
    private Car car;
    private List<String> phoneNumber;

    public Tenants() {
    }

    public Tenants(String name, int age, Car car,List<String> phoneNumber) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenants tenants = (Tenants) o;
        return age == tenants.age && Objects.equals(name, tenants.name) && Objects.equals(car, tenants.car) && Objects.equals(phoneNumber, tenants.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, car, phoneNumber);
    }

    @Override
    public String toString() {
        return "Tenants{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

