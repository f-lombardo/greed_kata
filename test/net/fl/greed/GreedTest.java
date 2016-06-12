package net.fl.greed;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import net.fl.greed.Greed;

import static java.util.Arrays.asList;


public class GreedTest {

  
  @Test
  public void mixedRules() throws Exception {
    assertScore(250, asList(2, 5, 2, 2, 3));
    assertScore(550, asList(5, 5, 5, 5, 3));
    assertScore(300, asList(1, 5, 5, 1, 6));
  }
  
  @Test
  public void three1() {
    assertGreaterOrEqual(1000, asList(1, 1, 1, 2, 3));
  }
  
  @Test
  public void three1AndTwo6() {
    assertScore(1000, asList(1, 1, 1, 6, 6));
  }

  @Test
  public void threeOfAnyOtherNumber() throws Exception {
    final int notOne = 4;
    assertGreaterOrEqual(100 * notOne, asList(notOne, notOne, notOne, 5, 2));
  }  
  
  @Test
  public void one1() throws Exception {
    final int notOne = 4;
    assertGreaterOrEqual(100, asList(notOne, notOne, notOne, 1, 2));
  }
  
  @Test
  public void one5() throws Exception {
    final int notFive = 4;
    assertGreaterOrEqual(50, asList(notFive, notFive, notFive, notFive, 5));
  }
  
  @Test
  public void three1AndTwo1() {
    assertScore(1200, asList(1, 1, 1, 1, 1));
  }
  
  @Test
  public void three1AndTwo5() {
    assertScore(1100, asList(1, 1, 1, 5, 5));
  }
  
  private void assertGreaterOrEqual(int expected, List<Integer> roll) {
    int score = new Greed().score(roll);
    assertTrue("Expected at least " + expected + " but was " + score, score >= expected);
  }

  private void assertScore(int score, List<Integer> dice) {
    assertEquals(score, new Greed().score(dice));
  }

}
