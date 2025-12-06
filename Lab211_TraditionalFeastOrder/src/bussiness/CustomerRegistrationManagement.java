/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import idao.ICustomerDAO;
import java.util.List;
import java.util.function.Predicate;
import model.Customer;
import tools.Acceptable;
import tools.Inputter;
import tools.Menu;

/**
 *
 * @author khoac
 */
public class CustomerRegistrationManagement {

    ICustomerDAO customerDAO;

    public CustomerRegistrationManagement(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void processForRegistration() {
        boolean stop = true;
        try {
            do {
                System.out.println("1. NEW REGISTRATION!");
                System.out.println("2. UPDATE REGISTRATION!");
                System.out.println("3. SEARCH CUSTOMER BY NAME!");
                System.out.println("4. SAVE CUSTOMER REGISTRATION!");
                System.out.println("5. DISPLAY CUSTOMER LISTS!");
                System.out.println("6. >>BACK TO MAIN MENU<<");
                System.out.println("Please choose: ");
                int choice = Inputter.getInt();
                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        updateCustomer();
                        break;
                    case 3:
                        String value = Inputter.getString("Enter Customer Name: ");
                        List<Customer> customers = searchCustomerName(value);
                        if (!customers.isEmpty()) {
                            System.out.println("Matching customers: " + value);
                            printCustomerList(customers);
                        } else {
                            System.out.println("No one matches the search criteria!");
                        }
                        break;
                    case 4:
                        saveCustomerList();
                        break;
                    case 5:
                        System.out.println("Customer information: ");
                        printCustomerList(customerDAO.getCustomers());
                        break;
                    case 6:
                        stop = false;
                        break;
                    default:
                        System.out.println("Choice invalid!");
                        break;
                }
            } while (stop);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Customer inputCustomer() {
        String code = Inputter.inputAndLoop("Enter customer code: ", Acceptable.CODE_VALID);
        String name = Inputter.inputAndLoop("Enter customer name: ", Acceptable.NAME_VALID);
        String phone = Inputter.inputAndLoop("Enter customer phone: ", Acceptable.PHONE_VALID);
        String email = Inputter.inputAndLoop("Enter customer email: ", Acceptable.EMAIL_VALID);
        return new Customer(code, name, phone, email);
    }

    public void changeCustomerInfo(Customer customer) {
        String name = Inputter.inputAndLoop("Enter new customer name: ", Acceptable.NAME_VALID);
        if (!name.isEmpty()) {
            customer.setName(name);
        }
        String phone = Inputter.inputAndLoop("Enter new customer phone: ", Acceptable.PHONE_VALID);
        if (!phone.isEmpty()) {
            customer.setPhone(phone);
        }
        String email = Inputter.inputAndLoop("Enter new customer email: ", Acceptable.EMAIL_VALID);
        if (!email.isEmpty()) {
            customer.setEmail(email);
        }
    }

    public void addCustomer() {
        try {
            Customer customer = inputCustomer();
            if (customerDAO.getCustomerByCode(customer.getCode()) != null) {
                System.out.println("This customer is already exist!");
                return;
            } else {
                customerDAO.addCustomer(customer);
                System.out.println("Register successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateCustomer() {
        try {
            String code = Inputter.inputAndLoop("Enter customer code: ", Acceptable.CODE_VALID);
            Customer customer = customerDAO.getCustomerByCode(code);
            if (customer == null) {
                System.out.println("This customer does not exist!");
                return;
            }
            changeCustomerInfo(customer);
            customerDAO.updateCustomer(customer);
            System.out.println("Update successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Customer> searchCustomerName(String value) {
        Predicate<Customer> predicate = p -> p.getName().toLowerCase().contains(value.toLowerCase());
        return customerDAO.search(predicate);
    }

    public void saveCustomerList() {
        customerDAO.saveCustomerList();
    }

    public void printCustomerList(List<Customer> customers) throws Exception {
        Menu.printHeaderForCustomer();
        for (Customer customer : customers) {
            Menu.printRowForCustomer(customer.getCode(), customer.getSplitName(), customer.getPhone(), customer.getEmail());
        }
    }
}
