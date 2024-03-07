package com.homework.entyti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Long good_id;

    private String good_name;

    private String good_brand;

    private String characteristics;

    private int good_weight;

    private Long good_price;

    private boolean availability;


    public Goods(String good_name, String good_brand, String characteristics, int good_weight,
                 Long good_price, boolean availability) {
        this.good_name = good_name;
        this.good_brand = good_brand;
        this.characteristics = characteristics;
        this.good_weight = good_weight;
        this.good_price = good_price;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Goods" +
                "good_id=" + good_id +
                ", good_name='" + good_name + '\'' +
                ", good_brand='" + good_brand + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", good_weight=" + good_weight + "kg" +
                ", good_price=" + good_price + "$"+
                ", availability=" + availability;
    }
}
