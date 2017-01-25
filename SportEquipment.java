package com.epam;

/**
 * class for unit sport equipment
 */
public class SportEquipment {
  private Category category;
  private String title;
  private int price;

  /**
   * constructor for creating unit sport equipment
   * @param category unit's category
   * @param title unit's title
   * @param price unit's price
   */
  SportEquipment(Category category,String title, int price) {
    this.category = category;
    this.title = title;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public int getPrice() {
    return price;
  }

  public String getCategory() {
    return category.getCategory();
  }
}
