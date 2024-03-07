package com.homework.entyti;

public class Goods {

    private Long good_id;

    private String name;

    private String brand;

    private String characteristics;

    private int weight;

    private int price;

    private boolean availability;

    public Goods() {
    }

    public Goods(Long good_id, String name, String brand, String characteristics,
                 int weight, int price, boolean availability) {
        this.good_id = good_id;
        this.name = name;
        this.brand = brand;
        this.characteristics = characteristics;
        this.weight = weight;
        this.price = price;
        this.availability = availability;
    }

    public Long getId() {
        return good_id;
    }

    public void setId(Long good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Good" +
                "id=" + good_id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", availability=" + availability;
    }
}
