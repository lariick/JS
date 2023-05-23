/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockxultimateversion;

import java.util.ArrayList;

/**
 *
 * @author nicor
 */
public class Shoe {
    
    private String brand;
    private String model;
    private String size;
    private String price;

    public Shoe(String brand, String model, String size, String price) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }
    
    /**
     *
     * @return
     */
    @Override
     public String toString() {
            return "Brand: " + brand + "\n" + "Model: " + model +"\n" + "Size: " + size + "\n" + "Price: $" + price + "\n" + "--------------------------\n";
     }      
}
