package net.fl.greed;

public class ThreeNoOnesRule implements Rule {

  public RuleResult apply(RuleResult result) {
    for (int toFind = 2; toFind <= 6; toFind++) {
      result = threeOccurrenciesOf(result, toFind);      
    }
    return result;
  }

  private RuleResult threeOccurrenciesOf(RuleResult previousResult, int toFind) {
    if (previousResult.occurrenciesOf(toFind) >= 3) {
      return previousResult
             .addScore(toFind * 100)
             .removeOccurrencies(3, toFind); 
    }
    return previousResult;
  }

}
