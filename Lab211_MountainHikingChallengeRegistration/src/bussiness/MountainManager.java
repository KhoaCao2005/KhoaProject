/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Mountain;
import tools.CSVReader;

/**
 *
 * @author khoac
 */
public class MountainManager {

    private String pathFile;
    private Map<String, Mountain> mountainMap;

    public MountainManager() {
        this.pathFile = "MountainList.csv";
        mountainMap = new HashMap<>();
        readFromFile();
    }

    public Mountain get(String mountainCode) {
        return mountainMap.get(mountainCode);
    }

    public boolean isValidMountainCode(String mountainCode) {
        return mountainMap.containsKey(mountainCode);
    }

    public Mountain parseMountain(String text) {
        String[] parts = text.split(",", -1);
        if (parts.length < 4) {
            System.err.println("Invalid CSV data: " + text);
            return null;
        }
        String mountainCode = parts[0].trim();
        String mountainName = parts[1].trim();
        String province = parts[2].trim();
        String description = parts[3].trim();
        return new Mountain(mountainCode, mountainName, province, description);
    }

    private void readFromFile() {
        CSVReader csvReader = new CSVReader(pathFile);
        List<String> lines = csvReader.readAllLines();
        for (String line : lines) {
            Mountain mountain = parseMountain(line);
            if (mountain != null) {
                mountainMap.put(mountain.getMountainCode(), mountain);
            }
        }
    }

    public void printAllMountains() {
        if (mountainMap.isEmpty()) {
            System.out.println("No mountains found.");
            return;
        }

        List<Mountain> mountainList = new ArrayList<>(mountainMap.values());

        Collections.sort(mountainList, (m1, m2) -> {
            try {
                int code1 = Integer.parseInt(m1.getMountainCode());
                int code2 = Integer.parseInt(m2.getMountainCode());
                return Integer.compare(code1, code2);
            } catch (NumberFormatException e) {
                return m1.getMountainCode().compareTo(m2.getMountainCode());
            }
        });

        System.out.println("List of Mountains:");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-25s %-20s %-40s%n", "MountainCode", "MountainName", "Province", "Description");
        System.out.println("------------------------------------------------------------------------------------------------------");

        for (Mountain m : mountainList) {
            System.out.printf("%-15s %-25s %-20s %-40s%n",
                    m.getMountainCode(),
                    m.getMountain(),
                    m.getProvince(),
                    m.getDescription());
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
