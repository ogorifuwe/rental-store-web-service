package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import java.math.BigDecimal;
import java.util.List;

public interface ItemDao {

<<<<<<< Updated upstream
    List<Item> findItembyName (String name);
    Item findItembyId (Integer id);
    List<Item> findItembyNameAndPrice (String name, BigDecimal dailyRate);
    Item addItem (Item item);
    void updateItem(Integer id);
    void deleteItem(Integer id);

=======
  /**
   * 8   FindItemByName
   * 9.  FindItemById
   * 10. FindItemByName&Price
   * 11. AddItem
   * 12. UpdateItem
   * 13. DeleteItem
   * 14. FindAllItems
   */

  Item findItemByName(String name);
  Item findItemById(Integer itemId);
  Item findItemByNameAndPrice(String name, BigDecimal dailyRate);
  Item addItem(Item item);
  void updateItem(Item item);
  void deleteItem(Integer itemId);
  List<Item> findAllItems();
>>>>>>> Stashed changes
}
