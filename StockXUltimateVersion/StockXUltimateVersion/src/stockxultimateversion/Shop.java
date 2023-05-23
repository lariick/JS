/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockxultimateversion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicor
 */
public class Shop {
    
    private ArrayList<Shoe> shoes = new ArrayList<>();
    private String filename;
    
    public Shop(String filename)
    {
        this.filename = filename;
        loadShoes();
    }
    
    
     public void loadShoes() {
        try {
            File file = new File(filename); //crea una nuova istanza(campo) nel file
            if (file.exists()) //controlla se il file essite
            {
                Scanner scanner = new Scanner(file); //leggiamo i valori in input
                while (scanner.hasNextLine()) //controlla se dopo la prima linea di input c'è ne è un'altra
                {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        String brand = data[0];
                        String model = data[1];
                        String size = data[2];
                        String price = data[3];
                        shoes.add(new Shoe(brand, model, size, price));
                    }
                }
                scanner.close(); //chiude lo scanner
            }
        } catch (FileNotFoundException e) //se non trova il file che gli è stato passato genera un messaggio di erroe
        {
            e.printStackTrace(); //messaggio di errore
        }
        
        
    }
    private void saveShoes() {
        try {
            FileWriter writer = new FileWriter(filename); //scrive sul file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Shoe shoe : shoes) {
                bufferedWriter.write(shoe.getBrand()+ "," + shoe.getModel() + "," + shoe.getSize() + "," + shoe.getPrice() + "\n");
                bufferedWriter.newLine(); //crea una nuova linea sotto per separazione
                bufferedWriter.flush(); //verifica che tutti i dati siano stati effettivamente scritti nel file
            }
            bufferedWriter.close(); //finisce di scrivere sul file
        } catch (IOException e) //controlla che il file su cui sta scrivendo essite o che abbia la possibilità di scriverci e se non è così genera un messaggio di errore
        {
            e.printStackTrace(); //messaggio di errore
        }
    }
    
    public void addShoe(String brand, String model, String size, String price) {
        shoes.add(new Shoe(brand, model, size, price));
        saveShoes();
    }
    
    
    public ArrayList<Shoe> searchShoesByBrand(String brand) {
        ArrayList<Shoe> results = new ArrayList<>();
        for (Shoe shoe : shoes) {
            if (shoe.getBrand().equalsIgnoreCase(brand)) {
                results.add(shoe);
            }
        }
        return results;
    }

    public ArrayList<Shoe> searchShoesByModel(String model) {
        ArrayList<Shoe> results = new ArrayList<>();
        for (Shoe shoe : shoes) {
            if (shoe.getModel().equalsIgnoreCase(model)) {
                results.add(shoe);
            }
        }
        return results;
    }
    
   
}
