package net.fl.greed;

public class ThreeItemsRule implements Rule {


  private final int toFind;
  private final ScoringStrategy scoringStrategy;
  
  public ThreeItemsRule(int toFind, ScoringStrategy scoringStrategy) {
    this.toFind = toFind;
    this.scoringStrategy = scoringStrategy;
  }
  
  public RuleResult apply(RuleResult previousResult) {
    if (previousResult.occurrenciesOf(toFind) >= 3) {
      return previousResult
             .addScore(scoringStrategy.score(toFind))
             .removeOccurrencies(3, toFind); 
    }
    return previousResult;
  }

}
