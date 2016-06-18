package net.fl.greed;

public class SingleItemRule implements Rule {

  private int toFind;
  private int score;
  
  public SingleItemRule(int toFind, int score) {
    this.toFind = toFind;
    this.score = score;
  }
  
  public RuleResult apply(RuleResult previousResult) {
    int occurrencies = previousResult.occurrenciesOf(toFind);
    return previousResult
           .addScore(score * occurrencies)
           .removeOccurrencies(occurrencies, toFind);
  }
}
