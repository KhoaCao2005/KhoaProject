/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Feast;
import tools.CSVReader;

/**
 *
 * @author khoac
 */
public class FeastList {

    private List<Feast> feastList;
    private final String pathFile = "FeastMenu.csv";

    public FeastList() {
        feastList = new ArrayList<>();
    }

    public boolean isFeastCodeExist(String feastCode) {
        File file = new File(pathFile);
        if (!file.exists()) {
            System.out.println("Cannot read data from \"" + pathFile + "\". Please check it.");
            return false;
        }

        List<Feast> feastListFromFile = CSVReader.readFeastMenu(pathFile);
        for (Feast feast : feastListFromFile) {
            if (feast.getCode().equalsIgnoreCase(feastCode)) {
                return true;
            }
        }
        return false;
    }

    public Feast getFeastByCode(String code) {
        File file = new File(pathFile);
        if (!file.exists()) {
            System.out.println("Cannot read data from \"" + pathFile + "\". Please check it.");
            return null;
        }
        List<Feast> feastListFromFile = CSVReader.readFeastMenu(pathFile);
        for (Feast feast : feastListFromFile) {
            if (feast.getCode().equalsIgnoreCase(code)) {
                return feast;
            }
        }
        return null;
    }

    public void run() {
        File file = new File(pathFile);
        if (!file.exists()) {
            System.out.println("Cannot read data from \"" + pathFile + "\". Please check it.");
            return;
        }

        feastList = CSVReader.readFeastMenu(pathFile);

        feastList.sort(Comparator.comparingDouble(Feast::getPrice));

        System.out.println("List of Set Menus for ordering party:\n");

        for (Feast feast : feastList) {
            System.out.println("-------------------------------------");
            System.out.println("Code     : " + feast.getCode());
            System.out.println("Name     : " + feast.getName());

            String priceFormatted = String.format("%,.0f Vnd", feast.getPrice());
            System.out.println("Price    : " + priceFormatted);

            System.out.println("Ingredients:");
            String[] lines = feast.getIngredients().split("#");
            for (String line : lines) {
                System.out.println(line.trim());
            }
            System.out.println();
        }
    }
}
