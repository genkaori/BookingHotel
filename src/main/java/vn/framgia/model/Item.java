package vn.framgia.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by FRAMGIA\duong.van.tien on 17/03/2017.
 */
public class Item {
    private int id;
    private String name;
    private float price;
    private String description;

    private Set<Booking> bookings = new HashSet<Booking>();

    public Item() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
