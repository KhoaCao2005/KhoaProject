/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.List;
import java.util.function.Predicate;
import model.Customer;

/**
 *
 * @author khoac
 */
public interface ICustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomerByCode(String code);
    
    void addCustomer(Customer customer);
    
    void updateCustomer(Customer customer);
    
    void saveCustomerList();
    
    List<Customer> search(Predicate<Customer> predicate);
    
    boolean isCustomerCodeExist(String code);
}
