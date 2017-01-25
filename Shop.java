package com.epam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * shop contains information about all goods available for rent
 */
public class Shop {
  /**
   * all goods in shop
   */
  private Map<SportEquipment, Integer> goods = new HashMap<>();

  /**
   * put information about goods into map
   *
   * @param category good's category
   * @param title    good's title
   * @param price    good's price
   * @param amount   good's amount
   */
  public void setGoods(String category, String title, int price, int amount) {
    goods.put(new SportEquipment(new Category(category), title, price), amount);
  }

  public Map<SportEquipment, Integer> getGoods() {
    return goods;
  }

  /**
   * print information about all goods before rent
   *
   * @param goods map contains information about all goods
   */
  public void getGoodsBeforeRent(Map<SportEquipment, Integer> goods) {
    System.out.println("Goods are in the shop: ");
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      System.out.println(entry.getKey().getCategory() + " " + entry.getKey().getTitle() + " " +
          entry.getKey().getPrice() + " " + entry.getValue());
    }
  }

  /**
   * print information about all goods after rent
   *
   * @param goods map contains information about all goods
   * @param units array contains rented goods
   */
  public void getGoodsAfterRent(Map<SportEquipment, Integer> goods, ArrayList<SportEquipment> units) {
    System.out.println("\nGoods are in the shop after rent: ");
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      int totalUnit = entry.getValue();
      for (int i = 0; i < units.size(); i++) {
        boolean equalsTitle = entry.getKey().getTitle().equals(units.get(i).getTitle());
        boolean equalsCategory = entry.getKey().getCategory().equals(units.get(i).getCategory());
        boolean equalsPrice = entry.getKey().getPrice() == units.get(i).getPrice();
        if (equalsTitle && equalsCategory && equalsPrice) {
          totalUnit--;
        }
      }
      System.out.println(entry.getKey().getCategory() + " " + entry.getKey().getTitle() + " " +
          entry.getKey().getPrice() + " " + totalUnit);
    }
  }
}
