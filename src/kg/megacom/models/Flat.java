package kg.megacom.models;

import java.util.List;
import java.util.Objects;

public class Flat {
    private int number;
    private int room;
    private List<Tenants> tenants;

    public Flat() {
    }

    public Flat(int number, int room, List<Tenants> tenants) {
        this.number = number;
        this.room = room;
        this.tenants = tenants;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public List<Tenants> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenants> tenants) {
        this.tenants = tenants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && room == flat.room && Objects.equals(tenants, flat.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, room, tenants);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", room=" + room +
                ", tenants=" + tenants +
                '}';
    }
}
