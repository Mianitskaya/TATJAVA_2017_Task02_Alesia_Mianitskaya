package com.epam;

/**
 * parser shop's range from rangeShop.txt
 */
public class ParserRange {
  /**
   * parse category from rangeShop.txt
   *
   * @param goods information about good from rangeShop.txt
   * @return good's category
   */
  public String parseCategory(String goods) {
    return goods.split("\\s+")[0];
  }

  /**
   * parse title from rangeShop.txt
   *
   * @param goods information about good from rangeShop.txt
   * @return good's title
   */
  public String parseTitle(String goods) {
    return goods.split("\\s+")[1];
  }

  /**
   * parse price from rangeShop.txt
   *
   * @param goods information about good from rangeShop.txt
   * @return good's price
   */
  public int parsePrice(String goods) {
    return Integer.parseInt(goods.split("\\s+")[2]);
  }

  /**
   * parse amount good from rangeShop.txt
   *
   * @param goods information about good from rangeShop.txt
   * @return amount good
   */
  public int parseAmount(String goods) {
    return Integer.parseInt(goods.split("\\s+")[3]);
  }
}
