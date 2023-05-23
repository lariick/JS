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
public class UserDatabase {
    
    private ArrayList<User> users = new ArrayList<>();
    private String filename;
    
     public UserDatabase(String filename) {
        this.filename = filename;
        loadUsers();
    }

    private void loadUsers() {
        try {
            File file = new File(filename); //crea una nuova istanza(campo) nel file
            if (file.exists()) //controlla se il file essite
            {
                Scanner scanner = new Scanner(file); //leggiamo i alori in input
                while (scanner.hasNextLine()) //controlla se dopo la prima linea di input c'è ne è un'altra
                {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length == 2) {
                        String email = data[0];
                        String password = data[1];
                        users.add(new User(email, password));
                    }
                }
                scanner.close(); //chiude lo scanner
            }
        } catch (FileNotFoundException e) //se non trova il file che gli è stato passato genera un messaggio di erroe
        {
            e.printStackTrace(); //messaggio di errore
        }
    }
    
    
    private void saveUsers() {
        try {
            FileWriter writer = new FileWriter(filename); //scrive sul file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (User user : users) {
                bufferedWriter.write(user.getEmail() + "," + user.getPassword() + "\n");
                bufferedWriter.newLine();
                bufferedWriter.flush(); //verifica che tutti i dati siano stati effettivamente scritti nel file
            }
            bufferedWriter.close(); //finisce di scrivere sul file
        } catch (IOException e) //controlla che il file su cui sta scrivendo essite o che abbia la possibilità di scriverci e se non è così genera un messaggio di errore
        {
            e.printStackTrace(); //messaggio di errore
        }
    }
    
     public boolean isLogin(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) { //equalsIgnoreCase = case insesitive (no differenza tra min e masc
                return true;
            }
        }
        return false;
    }
     
        public boolean isTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
    
    public void addUser(String email, String password) {
        users.add(new User(email, password));
        saveUsers();
    }
}
