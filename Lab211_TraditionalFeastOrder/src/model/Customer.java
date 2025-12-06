/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author khoac
 */
public class Customer implements Serializable {

    private String code;
    private String name;
    private String splitName;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String code, String name, String phone, String email) {
        this.code = code;
        this.name = name;
        this.splitName = splitName;
        this.phone = phone;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSplitName() {
        return splitName(name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Customer Code: %s"
                + "\nName: %s"              
                + "\nPhone Number: %s"
                + "\nEmail: %s",
                code, name, phone, email);
    }

    public String splitName(String name) {
        String[] arr = name.trim().split("\\s+");
        if (arr.length == 1) {
            return name;
        }

        String lastName = arr[arr.length - 1];
        String firstName = arr[0];
        String middleNames = String.join(" ", java.util.Arrays.copyOfRange(arr, 1, arr.length - 1));

        return lastName + ", " + firstName + (middleNames.isEmpty() ? "" : " " + middleNames);
    }
}
