package net.fl.greed;

public class ThreeItemsRule implements Rule {
  public RuleResult apply(RuleResult result) {
    for (int toFind = 1; toFind <= 6; toFind++) {
      result = threeOccurrenciesOf(result, toFind);      
    }
    return result;
  }

  private RuleResult threeOccurrenciesOf(RuleResult previousResult, int toFind) {
    if (previousResult.occurrenciesOf(toFind) >= 3) {
      return previousResult
             .addScore(score(toFind))
             .removeOccurrencies(3, toFind); 
    }
    return previousResult;
  }

  protected int score(int toFind) {
    if (toFind == 1) {
      return 1000;
    }
    return toFind * 100;
  }
}
