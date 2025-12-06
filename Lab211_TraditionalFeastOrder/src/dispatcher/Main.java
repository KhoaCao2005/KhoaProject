/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatcher;

import dao.CustomerDAO;
import dao.FeastOrderDAO;
import idao.ICustomerDAO;
import idao.IFeastOrderDAO;
import tools.Inputter;
import tools.Menu;

/**
 *
 * @author khoac
 */
public class Main {
    public static void main(String[] args) {
        int choice;
        try {
            do {
                System.out.println("1. GO TO REGISTRATION!");
                System.out.println("2. GO TO ORDER FEAST!");
                System.out.println("3. >>QUIT PROGRAM<<");
                System.out.println("Please choose: ");
                choice = Inputter.getInt();
                switch (choice) {
                    case 1:
                        ICustomerDAO customerService = new CustomerDAO();
                        Menu.registerForCustomer(customerService);
                        break;
                    case 2:
                        IFeastOrderDAO feastOrderService = new FeastOrderDAO();
                        Menu.orderForFeast(feastOrderService);
                        break;
                    case 3:
                        System.out.println("See you again!");
                        System.exit(0);
                        break;
                }
            } while (true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
