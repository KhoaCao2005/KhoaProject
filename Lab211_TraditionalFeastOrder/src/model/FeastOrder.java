/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author khoac
 */
public class FeastOrder implements Serializable {

    private String customerCode;
    private String setCode;
    private int table;
    private LocalDate date;
    private String orderId;

    public FeastOrder() {
    }

    public FeastOrder(String customerCode, String setCode, int table, LocalDate date) {
        this.customerCode = customerCode;
        this.setCode = setCode;
        this.table = table;
        this.date = date;
        this.orderId = orderId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return String.format("Customer Code: %s"
                + "\nSet Code: %s"
                + "\nNumber Of Table: %s"
                + "\nDate: %s",
                customerCode, setCode, table, date);
    }

}
