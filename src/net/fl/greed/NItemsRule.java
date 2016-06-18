package net.fl.greed;

public class NItemsRule implements Rule {

  private int toFind;
  private int score;
  private int numberOfItems;
  
  public NItemsRule(int toFind, int score, int numberOfItems) {
    this.toFind = toFind;
    this.score = score;
    this.numberOfItems = numberOfItems;
  }
  
  public RuleResult apply(RuleResult previousResult) {
    while (previousResult.occurrenciesOf(toFind) >= numberOfItems) {
      previousResult =  previousResult
                        .addScore(score)
                        .removeOccurrencies(numberOfItems, toFind);
    }
    return previousResult;
  }
}
