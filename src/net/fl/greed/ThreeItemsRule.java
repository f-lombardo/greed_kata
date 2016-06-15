package net.fl.greed;

public class ThreeItemsRule implements Rule {


  private final int toFind;
  private int score;
  
  public ThreeItemsRule(int toFind, int score) {
    this.toFind = toFind;
    this.score = score;
  }
  
  public RuleResult apply(RuleResult previousResult) {
    if (previousResult.occurrenciesOf(toFind) >= 3) {
      return previousResult
             .addScore(score)
             .removeOccurrencies(3, toFind); 
    }
    return previousResult;
  }

}
