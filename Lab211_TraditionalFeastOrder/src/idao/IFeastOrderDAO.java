/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idao;

import java.util.List;
import java.util.function.Predicate;
import model.FeastOrder;

/**
 *
 * @author khoac
 */
public interface IFeastOrderDAO {

    List<FeastOrder> getFeast();
    
    FeastOrder getFeastOrderByOID(String orderId);

    void addFeastOrder(FeastOrder feastOrder);

    void updateFeastOrder(FeastOrder feastOrder);

    void saveFeastOrderList();
    
    List<FeastOrder> search(Predicate<FeastOrder> predicate);
}
