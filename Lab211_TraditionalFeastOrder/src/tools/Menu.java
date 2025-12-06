/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import bussiness.CustomerRegistrationManagement;
import bussiness.FeastOrderManagement;
import idao.ICustomerDAO;
import idao.IFeastOrderDAO;
import java.time.LocalDate;
import java.util.Collections;

/**
 *
 * @author khoac
 */
public class Menu {

    public static void printHeaderForCustomer() {
        System.out.println(String.join("", Collections.nCopies(80, "-")));
        String headerFormat = "%-15s | %-20s | %-15s | %-25s%n";
        System.out.format(headerFormat,
                "Customer Code", "Customer Name", "Customer Phone", "Customer Email");
        System.out.println(String.join("", Collections.nCopies(80, "-")));
    }

    public static void printHeaderForFeastOrder() {
        System.out.println(String.join("", Collections.nCopies(140, "-")));
        String headerFormat = "%-15s | %-20s | %-15s | %-25s | %-20s | %-15s | %-20s%n";
        System.out.format(headerFormat,
                "ID", "Event date", "Customer ID", "Set Menu", "Price", "Tables", "Cost");
        System.out.println(String.join("", Collections.nCopies(140, "-")));
    }

    public static void printRowForCustomer(String code, String name, String phone, String email) {
        String rowFormat = "%-15s | %-20s | %-15s | %-25s%n";
        System.out.format(rowFormat, code, name, phone, email);
        System.out.println(String.join("", Collections.nCopies(80, "-")));
    }
    
    public static void printRowForFeastOrder(String orderId, LocalDate eventDate, String customerCode, String setCode, double price, int table, double totalCost){
        String rowFormat = "%-15s | %-20s | %-15s | %-25s | %-20.0f | %-15d | %-20.0f%n";
        System.out.format(rowFormat, orderId, eventDate, customerCode, setCode, price, table, totalCost);
        System.out.println(String.join("", Collections.nCopies(140, "-")));
    }

    public static void registerForCustomer(ICustomerDAO service) {
        CustomerRegistrationManagement cusMenu = new CustomerRegistrationManagement(service);
        cusMenu.processForRegistration();
    }

    public static void orderForFeast(IFeastOrderDAO service) {
        FeastOrderManagement fstMenu = new FeastOrderManagement(service);
        fstMenu.processForOrder();
    }
}
