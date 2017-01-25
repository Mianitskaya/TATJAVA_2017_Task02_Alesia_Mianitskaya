package com.epam;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Class contains information about rented units
 */
public class RentUnit {
  /**
   * maximum value of available units for rent
   */
  private final int LIMIT_UNITS = 3;
  /**
   * all rented units of goods
   */
  private ArrayList<SportEquipment> units;

  /**
   * do goods rent
   *
   * @param goods map contains information about all goods
   * @return ArrayList units contains rented goods
   */
  public ArrayList<SportEquipment> doRent(Map<SportEquipment, Integer> goods) {
    units = new ArrayList<>();
    String answer;
    do {
      SportEquipment wantedUnits;
      if (units.size() == LIMIT_UNITS) {
        System.out.println("Sorry, you can not rent more than three goods. ");
        break;
      }
      wantedUnits = enterWantedGood();
      if (!findUnit(wantedUnits, goods)) {
        System.out.println("Unfortunately, unit is not in the shop.");
      } else {
        units.add(wantedUnits);
      }
      System.out.println("If you want more goods enter - yes, otherwise enter - no: ");
      Scanner scanner = new Scanner(System.in);
      answer = scanner.next();
    } while (answer.equals("yes"));
    return units;
  }

  /**
   * enter information about wanted good
   *
   * @return wanted good
   */
  private SportEquipment enterWantedGood() {
    System.out.println("Please, enter category, title and price of good, which you want to rent: ");
    Scanner scanner = new Scanner(System.in);
    String category = scanner.next();
    String title = scanner.next();
    int price = scanner.nextInt();
    return new SportEquipment(new Category(category), title, price);
  }

  /**
   * find wanted good in shop
   *
   * @param unit  wanted good
   * @param goods all goods in shop
   * @return true if unit is in shop otherwise false
   */
  private boolean findUnit(SportEquipment unit, Map<SportEquipment, Integer> goods) {
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      boolean equalsTitle = entry.getKey().getTitle().equals(unit.getTitle());
      boolean equalsCategory = entry.getKey().getCategory().equals(unit.getCategory());
      boolean equalsPrice = entry.getKey().getPrice() == unit.getPrice();
      boolean presence = entry.getValue() != 0;
      if (equalsTitle && equalsCategory && equalsPrice && presence) {
        return true;
      }
    }
    return false;
  }

  /**
   * print information about rented goods
   *
   * @param units ArrayList contains rented goods
   */
  public void showRented(ArrayList<SportEquipment> units) {
    if (units.size() == 0) {
      System.out.println("\nNo goods rented.");
    } else {
      System.out.println("\nRented goods now: ");
      for (int i = 0; i < units.size(); i++) {
        System.out.println(units.get(i).getCategory() + " " + units.get(i).getTitle() + " " + units.get(i).getPrice());
      }
    }
  }
}
