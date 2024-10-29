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
public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
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
    public void inputPainting(){
        super.inputItem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap height: ");
        this.height = sc.nextInt();
        System.out.println("Nhap width: ");
        this.width = sc.nextInt();
        System.out.println("Co mau(true/false): ");      
        this.isWatercolour = sc.nextBoolean();
        System.out.println("Co khung(true/false): ");
        this.isFramed = sc.nextBoolean();
    }
    public void outputPainting(){
        super.outputItem();
        System.out.println("Height: "+this.height);
        System.out.println("Width: "+this.width);
        System.out.println("Co mau: "+this.isWatercolour);
        System.out.println("Co khung: "+this.isFramed);
    }
    
}
