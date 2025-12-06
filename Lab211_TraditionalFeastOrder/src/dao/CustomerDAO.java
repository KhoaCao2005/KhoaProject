/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import idao.ICustomerDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Customer;

/**
 *
 * @author khoac
 */
public class CustomerDAO implements ICustomerDAO {

    private List<Customer> customerList = new ArrayList<>();
    private final FileManager fileManager;

    public CustomerDAO() {
        this.fileManager = new FileManager("customers.dat");
        loadData();
    }

    private void loadData() {
        List<Customer> customers = fileManager.readObjectsFromFile();
        if (customers.isEmpty()) {
            System.out.println("No customer have register yet!");
        } else {
            customerList.addAll(customers);
        }
    }

    @Override
    public List<Customer> getCustomers() {
        if (customerList == null) {
            return new ArrayList<>();
        }
        List<Customer> sortedList = new ArrayList<>(customerList);
        Collections.sort(sortedList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        return sortedList;
    }

    @Override
    public Customer getCustomerByCode(String code) {
        if (customerList == null || customerList.isEmpty()) {
            getCustomers();
        }
        Customer customer = customerList.stream().filter(e -> e.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
        return customer;
    }
    public Customer getCustomerByPhone(String phone) {
        if (customerList == null || customerList.isEmpty()) {
            getCustomers();
        }
        Customer customer = customerList.stream().filter(e -> e.getPhone().equalsIgnoreCase(phone)).findAny().orElse(null);
        return customer;
    }
    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer existingCustomer = getCustomerByCode(customer.getCode());
        if (existingCustomer == null) {
            System.out.println("This customer does not exist!");
        }
        if (customer.getName() != null) {
            existingCustomer.setName(customer.getName());
        }
        if (customer.getPhone() != null) {
            existingCustomer.setPhone(customer.getPhone());
        }
        if (customer.getEmail() != null) {
            existingCustomer.setEmail(customer.getEmail());
        }
    }

    @Override
    public void saveCustomerList() {
        fileManager.saveOjectsToFile(customerList);
    }

    @Override
    public List<Customer> search(Predicate<Customer> predicate) {
        return customerList.stream().filter(customer -> predicate.test(customer)).collect(Collectors.toList());
    }

    @Override
    public boolean isCustomerCodeExist(String code) {
        for (Customer customer : customerList) {
            if (customer.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

}
