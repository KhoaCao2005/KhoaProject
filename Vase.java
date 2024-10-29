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
public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int height, String material, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
    public void inputVase(){
        super.inputItem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap height: ");
        this.height = sc.nextInt();
        System.out.println("Nhap material: ");
        sc = new Scanner(System.in);
        this.material = sc.nextLine();
    }
    public void outputVase(){
        super.outputItem();
        System.out.println("Height: "+this.height);
        System.out.println("Material: "+this.material);
    }
}
