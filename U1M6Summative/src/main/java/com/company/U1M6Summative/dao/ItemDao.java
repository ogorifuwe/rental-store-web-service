package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import java.math.BigDecimal;
import java.util.List;

public interface ItemDao {

    List<Item> findItembyName (String name);
    Item findItembyId (Integer id);
    List<Item> findItembyNameAndPrice (String name, BigDecimal dailyRate);
    Item addItem (Item item);
    void updateItem(Integer id);
    void deleteItem(Integer id);

}
