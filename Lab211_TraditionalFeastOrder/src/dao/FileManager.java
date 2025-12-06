/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khoac
 */
public class FileManager {

    private final String fileName;

    public FileManager(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name must not be null or empty!");
        }
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File " + fileName + " created successfully!");
                    saveOjectsToFile(new ArrayList<>());
                } else {
                    System.err.println("Failed to create file " + fileName);
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public <T> void saveOjectsToFile(List<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public <T> List<T> readObjectsFromFile() {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            System.out.println("File not found! Returning an empty list!");
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
