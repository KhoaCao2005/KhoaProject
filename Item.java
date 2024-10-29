/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author khoac
 */
public class Item {

    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void inputItem() {
        Scanner sc = new Scanner(System.in);
        int v;
        do {
            System.out.println("Nhap gia tri value (>0): ");
            v = sc.nextInt();
        } while (v <= 0);
        this.value = v;

        String c = "";
        do {
            sc = new Scanner(System.in);
            System.out.println("Nhap creator: ");
            c = sc.nextLine();
        } while ((c.trim()).isEmpty());

        this.creator = c;
    }

    public void outputItem() {
        System.out.println("Value: " + this.getValue());
        System.out.println("Creator: " + this.getCreator());
    }
}
