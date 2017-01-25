package com.epam;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * class for reading file contains information about goods
 */
public class ReaderRange {
  private final String PATH = ".\\rangeShop.txt";

  /**
   * reads txt file with written range of shop
   * and writes it in ArrayList
   *
   * @param goodsList - ArrayList for writing range of shop
   * @return ArrayList with range of shop
   */
  public ArrayList<String> readRange(ArrayList<String> goodsList) {
    try {
      Path path = Paths.get(PATH);
      BufferedReader bufferedReader = Files.newBufferedReader(path);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        goodsList.add(line);
      }
      bufferedReader.close();
    } catch (Exception e) {
      System.out.println("File with range not found.");
    }
    return goodsList;
  }
}
