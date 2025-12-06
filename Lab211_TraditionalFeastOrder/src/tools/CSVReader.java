/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Feast;

/**
 *
 * @author khoac
 */
public class CSVReader {

    public static List<Feast> readFeastMenu(String filePath) {
        List<Feast> feastList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length >= 4) {
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    double price = 0.0;

                    try {
                        price = Double.parseDouble(parts[2].trim());
                    } catch (NumberFormatException e) {
                        System.err.println("Error: " + e.getMessage());
                    }

                    String ingredients = parts[3].trim();
                    ingredients = ingredients.replace("\"", "");
                    Feast feast = new Feast(code, name, price, ingredients);
                    feastList.add(feast);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return feastList;
    }
}
