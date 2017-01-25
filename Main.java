package com.epam;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Start point of the program
 */
public class Main {
  /**
   * Print all goods in shop before rent, then enter wanted units,
   * if wanted units are available, they are rented
   * at a time you can't take more than three units
   * then print goods, that were left in shop after rent
   *
   * @param args command line argument
   */
  public static void main(String[] args) {
    ArrayList<String> goodsList = new ArrayList<>();
    ReaderRange readerRange = new ReaderRange();
    readerRange.readRange(goodsList);
    Shop shop = new Shop();
    if (!goodsList.isEmpty()) {
      for (int i = 1; i < goodsList.size(); i++) {
        ParserRange pr = new ParserRange();
        String goods = goodsList.get(i);
        shop.setGoods(pr.parseCategory(goods), pr.parseTitle(goods), pr.parsePrice(goods), pr.parseAmount(goods));
      }
    }
    shop.getGoodsBeforeRent(shop.getGoods());
    try {
      RentUnit rentUnit = new RentUnit();
      ArrayList<SportEquipment> units = rentUnit.doRent(shop.getGoods());
      rentUnit.showRented(units);
      /// goods in shop now
      shop.getGoodsAfterRent(shop.getGoods(), units);
    } catch (InputMismatchException e) {
      System.out.println("Input data is not valid.");
    }
  }
}
