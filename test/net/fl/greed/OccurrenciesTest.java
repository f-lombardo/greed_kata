package net.fl.greed;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OccurrenciesTest {

  @Test
  public void canFindOccurrenciesOfNumbers() {
    Occurrencies occurrencies = new Occurrencies(asList(1,1,1,2,2,3));
    assertEquals(3, occurrencies.of(1));
    assertEquals(2, occurrencies.of(2));
    assertEquals(1, occurrencies.of(3));
    assertEquals(0, occurrencies.of(4));
  }

  @Test
  public void canRemoveOccurrenciesOfNumbers() {
    Occurrencies occurrencies = new Occurrencies(asList(1,1,1,2,2,3)).remove(2, 1);
    assertEquals(1, occurrencies.of(1));
    occurrencies.remove(10, 1);
    assertEquals(0, occurrencies.of(1));
  }
  
  @Test
  public void removingZeroOccurrenciesDoesntChangeAnything() {
    Occurrencies occurrencies = new Occurrencies(asList(1,1,1,2,2,3)).remove(2, 1);
    assertEquals(1, occurrencies.of(1));
    occurrencies.remove(0, 1);
    assertEquals(1, occurrencies.of(1));
  }
}
