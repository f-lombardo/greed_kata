package net.fl.greed;

import java.util.List;

import static java.util.Arrays.asList;

public class Occurrencies {

  private static final int FACES_OF_A_DIE = 6;
  
  private final int[] occurrencies;

  public Occurrencies(List<Integer>numbers) {
    occurrencies = new int[FACES_OF_A_DIE + 1];
    for (Integer number : numbers) {
      occurrencies[number]++;
    }
  }

  public static Occurrencies in(Integer... numbers) {
    return new Occurrencies(asList(numbers));
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
