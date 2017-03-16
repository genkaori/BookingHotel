package vn.framgia.bean;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public class ItemBean implements Serializable {
    private int id;
    private String name;
    private float price;
    private String description;

    public ItemBean() {}

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
}
