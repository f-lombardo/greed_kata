package net.fl.greed;

import java.util.List;

public class Occurrencies {
  private static final int FACES_OF_A_DIE = 6;
  
  private final int[] occurrencies;

  public Occurrencies(List<Integer>numbers) {
    occurrencies = new int[FACES_OF_A_DIE + 1];
    for (Integer number : numbers) {
      occurrencies[number]++;
    }
  }

  public int of(Integer toFind) {
    return occurrencies[toFind];
  }

  public Occurrencies remove(int times, int number) {
    if (occurrencies[number] > times) {
      occurrencies[number] -= times;
    } else {
      occurrencies[number] = 0;
    }
    return this;
  }
}
