package com.company.U1M6Summative.dao;

<<<<<<< Updated upstream
public class ItemDaoJdbcImpl {
=======
import com.company.U1M6Summative.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoJdbcImpl implements ItemDao {

  private JdbcTemplate jdbcTemplate;

  private static final String SELECT_ITEM_BY_NAME_SQL =
          "select * from  item where name = ?";

  private static final String SELECT_ITEM_BY_ID_SQL =
          "select * from item where item_id = ?";

  private static final String SELECT_ITEM_BY_NAME_AND_PRICE_SQL =
          "select * from item where name = ? and daily_rate = ?";

 private static final String INSERT_ITEM_SQL =
         "insert into item (name, description, daily_rate) values (?, ?, ?)";

  private static final String UPDATE_ITEM_SQL =
          "update item set name = ?, description = ?, daily_rate = ?";

  private static final String DELETE_ITEM =
          "delete from item where item_id = ?";

  private static final String SELECT_ALL_ITEMS_SQL =
          "select * from item";

  @Autowired
  public ItemDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Item findItemByName(String name) {
    try {
      return jdbcTemplate.queryForObject(SELECT_ITEM_BY_NAME_SQL, this::mapRowToItem, name);
    } catch (EmptyResultDataAccessException e) {
        /* if there is no match for this item name, return null */
        return null;
    }
  }

  @Override
  public Item findItemById(Integer itemId) {

    try {
      return jdbcTemplate.queryForObject(SELECT_ITEM_BY_ID_SQL, this::mapRowToItem, itemId);
    } catch (EmptyResultDataAccessException e) {
        /* if there is no match for this item id, return null */
        return null;
    }
  }

  @Override
  public Item findItemByNameAndPrice(String name, BigDecimal dailyRate) {

    try {
      return jdbcTemplate.queryForObject(SELECT_ITEM_BY_NAME_AND_PRICE_SQL, this::mapRowToItem, name, dailyRate);
    } catch (EmptyResultDataAccessException e) {
        /* if there is no match for this item name and price, return null */
        return null;
    }
  }

  @Override
  @Transactional
  public Item addItem(Item item) {

    jdbcTemplate.update(
            INSERT_ITEM_SQL,
            item.getName(),
            item.getDescription(),
            item.getDailyRate());

    int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

    item.setItemId(id);

    return item;
  }

  @Override
  public void updateItem(Item item) {

    jdbcTemplate.update(
            UPDATE_ITEM_SQL,
            item.getName(),
            item.getDescription(),
            item.getDailyRate());
  }

  @Override
  public void deleteItem(Integer itemId) {

    jdbcTemplate.update(DELETE_ITEM, itemId);
  }

  @Override
  public List<Item> findAllItems() {

    return jdbcTemplate.query(SELECT_ALL_ITEMS_SQL, this::mapRowToItem);
  }

  private Item mapRowToItem(ResultSet rs, int rowNum) throws SQLException {
    Item item = new Item();
    item.setItemId(rs.getInt("item_id"));
    item.setName(rs.getString("name"));
    item.setDescription(rs.getString("description"));
    item.setDailyRate(rs.getBigDecimal("daily_rate"));

    return item;
  }
>>>>>>> Stashed changes
}
