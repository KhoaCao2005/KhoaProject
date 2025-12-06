/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import idao.IFeastOrderDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.FeastOrder;

/**
 *
 * @author khoac
 */
public class FeastOrderDAO implements IFeastOrderDAO {

    private CustomerDAO customerDao = new CustomerDAO();
    private List<FeastOrder> feastOrderList = new ArrayList<>();
    private final FileManager fileManager;

    public FeastOrderDAO() {
        this.fileManager = new FileManager("feast_order_service.dat");
        loadData();
    }

    private void loadData() {
        List<FeastOrder> feastOrders = fileManager.readObjectsFromFile();
        if (feastOrders.isEmpty()) {
            System.out.println("No order have been placed yet!");
        } else {
            feastOrderList.addAll(feastOrders);
        }
    }

    @Override
    public List<FeastOrder> getFeast() {
        if (feastOrderList == null) {
            return new ArrayList<>();
        }
        List<FeastOrder> sortedList = new ArrayList<>(feastOrderList);
        Collections.sort(sortedList, (e1, e2) -> e1.getDate().compareTo(e2.getDate()));
        return sortedList;
    }

    @Override
    public void addFeastOrder(FeastOrder feastOrder) {
        feastOrderList.add(feastOrder);
    }

    @Override
    public void updateFeastOrder(FeastOrder feastOrder) {
        FeastOrder existingFeastOrder = getFeastOrderByOID(feastOrder.getOrderId());
        if (existingFeastOrder == null) {
            System.out.println("This order does not exist!");
        }
        if (feastOrder.getSetCode() != null) {
            existingFeastOrder.setSetCode(feastOrder.getSetCode());
        }
        existingFeastOrder.setTable(feastOrder.getTable());
        if (feastOrder.getDate() != null) {
            existingFeastOrder.setDate(feastOrder.getDate());
        }
    }

    @Override
    public void saveFeastOrderList() {
        fileManager.saveOjectsToFile(feastOrderList);
    }

    @Override
    public FeastOrder getFeastOrderByOID(String orderId) {
        if (feastOrderList == null || feastOrderList.isEmpty()) {
            getFeast();
        }
        FeastOrder feastOrder = feastOrderList.stream().filter(e -> e.getOrderId().equalsIgnoreCase(orderId)).findAny().orElse(null);
        return feastOrder;
    }

    @Override
    public List<FeastOrder> search(Predicate<FeastOrder> predicate) {
        return feastOrderList.stream().filter(feastOrder -> predicate.test(feastOrder)).collect(Collectors.toList());
    }
}
