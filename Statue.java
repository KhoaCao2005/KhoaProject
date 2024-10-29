/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;
import javax.swing.text.html.HTML;

/**
 *
 * @author khoac
 */
public class Statue extends Item {

    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int weight, String colour, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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

    public void inputStatue() {
        super.inputItem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap weight: ");
        this.weight = sc.nextInt();
        System.out.println("Nhap colour: ");
        sc = new Scanner(System.in);
        this.colour = sc.nextLine();
    }

    public void outputStatue() {
        super.outputItem();
        System.out.println("Weight: " + this.weight);
        System.out.println("Colour: " + this.colour);
    }

}
