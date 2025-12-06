/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

import dao.CustomerDAO;
import dao.FeastList;
import idao.IFeastOrderDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Customer;
import model.Feast;
import model.FeastOrder;
import tools.Inputter;
import tools.Menu;

/**
 *
 * @author khoac
 */
public class FeastOrderManagement {

    private CustomerDAO customerDao = new CustomerDAO();
    FeastList feastList = new FeastList();
    IFeastOrderDAO feastOrderDao;

    public FeastOrderManagement(IFeastOrderDAO feastOrderDao) {
        this.feastOrderDao = feastOrderDao;
    }

    public void processForOrder() {
        boolean stop = true;
        try {
            do {
                System.out.println("1. DISPLAY FEAST MENUS!");
                System.out.println("2. PLACE A FEAST ORDER!");
                System.out.println("3. UPDATE ORDER INFORMATION!");
                System.out.println("4. SAVE FEAST ORDER!");
                System.out.println("5. DISPLAY ORDER LISTS!");
                System.out.println("6. >>BACK TO MAIN MENU<<");
                System.out.println("Please choose: ");
                int choice = Inputter.getInt();
                switch (choice) {
                    case 1:
                        feastList.run();
                        break;
                    case 2:
                        addFeastOrder();
                        break;
                    case 3:
                        updateFeastOrder();
                        break;
                    case 4:
                        saveFeastOrderList();
                        break;
                    case 5:
                        printAllOrders(feastOrderDao.getFeast());
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

    public FeastOrder inputFeastOrder() {
        String customerCode = Inputter.getString("Enter customer code: ");
        if (!customerDao.isCustomerCodeExist(customerCode)) {
            System.out.println("Customer code does not exist! Please register first.");
            return null;
        }
        String setCode;
        while (true) {
            setCode = Inputter.getString("Enter set menu code: ");
            if (setCode.trim().isEmpty()) {
                System.out.println("Set code can not be left blank!");
            } else if (!feastList.isFeastCodeExist(setCode)) {
                System.out.println("Set code not exists!");
            } else {
                break;
            }
        }
        int table;
        while (true) {
            table = Inputter.getInt("Enter number of table: ");
            if (table < 1) {
                System.out.println("Number of table must be greater than or equal to 1. Please enter again!");
            } else {
                break;
            }
        }
        LocalDate date;
        while (true) {
            date = Inputter.inputLocalDate("Enter date: ");
            if (!date.isAfter(LocalDate.now())) {
                System.out.println("Date must be in the future. Please enter again!");
            } else {
                break;
            }
        }
        return new FeastOrder(customerCode, setCode, table, date);
    }

    public void changeFeastOrderInfo(FeastOrder feastOrder) {
        String setCode;
        while (true) {
            setCode = Inputter.getString("Enter set menu code: ");
            if (setCode.trim().isEmpty()) {
                System.out.println("Set code can not be left blank!");
            } else if (!feastList.isFeastCodeExist(setCode)) {
                System.out.println("Set code not exists!");
            } else {
                break;
            }
        }
        if (!setCode.isEmpty()) {
            feastOrder.setSetCode(setCode);
        }
        int table;
        while (true) {
            table = Inputter.getInt("Enter number of table: ");
            if (table < 1) {
                System.out.println("Number of table must be greater than or equal to 1. Please enter again!");
            } else {
                break;
            }
        }
        feastOrder.setTable(table);
        LocalDate date;
        while (true) {
            date = Inputter.inputLocalDate("Enter date: ");
            if (!date.isAfter(LocalDate.now())) {
                System.out.println("Date must be in the future. Please enter again!");
            } else {
                break;
            }
        }
        feastOrder.setDate(date);
    }

    public void addFeastOrder() {
        try {
            FeastOrder feastOrder = inputFeastOrder();
            if (feastOrder == null) {
                return;
            }
            if (isDuplicateOrder(feastOrder)) {
                System.out.println("Dupplicate data");
                return;
            }
            Customer customer = customerDao.getCustomerByCode(feastOrder.getCustomerCode());
            if (customer == null) {
                System.out.println("Cannot find customer data!");
                return;
            }
            Feast feast = feastList.getFeastByCode(feastOrder.getSetCode());
            if (feast == null) {
                System.out.println("Set menu not found!");
                return;
            }
            String orderId = generateOrderId();
            feastOrder.setOrderId(orderId);
            feastOrderDao.addFeastOrder(feastOrder);
            System.out.println("Order successfully!");
            printOrderDetails(feastOrder, customer, feast);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateFeastOrder() {
        try {
            String orderId = Inputter.getString("Enter order id: ");
            FeastOrder feastOrder = feastOrderDao.getFeastOrderByOID(orderId);
            if (feastOrder == null) {
                System.out.println("This order does not exist!");
                return;
            }
            changeFeastOrderInfo(feastOrder);
            feastOrderDao.updateFeastOrder(feastOrder);
            System.out.println("Update succesfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void saveFeastOrderList() {
        feastOrderDao.saveFeastOrderList();
    }

    private boolean isDuplicateOrder(FeastOrder order) {
        List<FeastOrder> orders = feastOrderDao.getFeast();
        for (FeastOrder o : orders) {
            if (o.getCustomerCode().equals(order.getCustomerCode())
                    && o.getSetCode().equals(order.getSetCode())
                    && o.getDate().equals(order.getDate())) {
                return true;
            }
        }
        return false;
    }

    private String generateOrderId() {
        List<FeastOrder> orders = feastOrderDao.getFeast();
        Set<Integer> usedIds = new HashSet<>();
        for (FeastOrder order : orders) {
            try {
                usedIds.add(Integer.parseInt(order.getOrderId()));
            } catch (NumberFormatException e) {
            }
        }
        int newId = 1;
        while (usedIds.contains(newId)) {
            newId++;
        }
        return String.valueOf(newId);
    }

    private void printOrderDetails(FeastOrder feastOrder, Customer customer, Feast feast) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String eventDateFormatted = feastOrder.getDate().format(dtf);

        double totalCost = feastOrder.getTable() * feast.getPrice();

        String priceFormatted = String.format("%,.0f Vnd", feast.getPrice());
        String totalFormatted = String.format("%,.0f Vnd", totalCost);

        System.out.println("\n--------------------------------------------------");
        System.out.println("Customer order information [Order ID: " + feastOrder.getOrderId() + "]");
        System.out.println("--------------------------------------------------");
        System.out.println("Code            : " + customer.getCode());
        System.out.println("Customer name   : " + customer.getName());
        System.out.println("Phone number    : " + customer.getPhone());
        System.out.println("Email           : " + customer.getEmail());
        System.out.println();
        System.out.println("Code of Set Menu  : " + feast.getCode());
        System.out.println("Set menu name     : " + feast.getName());
        System.out.println("Event date        : " + eventDateFormatted);
        System.out.println("Number of tables  : " + feastOrder.getTable());
        System.out.println("Price per table   : " + priceFormatted);
        System.out.println();
        System.out.println("Ingredients:");
        String[] lines = feast.getIngredients().split("#");
        for (String line : lines) {
            System.out.println("  " + line.trim());
        }
        System.out.println();
        System.out.println("Total cost       : " + totalFormatted);
        System.out.println("--------------------------------------------------\n");
    }

    public void printAllOrders(List<FeastOrder> feastOrders) throws Exception {
        Menu.printHeaderForFeastOrder();
        for (FeastOrder feastOrder : feastOrders) {
            Feast feast = feastList.getFeastByCode(feastOrder.getSetCode());
            double totalCost = feastOrder.getTable() * feast.getPrice();
            Menu.printRowForFeastOrder(
                    feastOrder.getOrderId(),
                    feastOrder.getDate(),
                    feastOrder.getCustomerCode(),
                    feastOrder.getSetCode(),
                    feast.getPrice(),
                    feastOrder.getTable(),
                    totalCost
            );
        }
    }
}
