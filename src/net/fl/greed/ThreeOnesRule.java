package net.fl.greed;

public class ThreeOnesRule implements Rule {

  public RuleResult apply(RuleResult previousResult) {
    if (previousResult.occurrenciesOf(1) >= 3) {
      return previousResult
             .addScore(1000)
             .removeOccurrencies(3, 1);
    }
    return previousResult;
  }

}
