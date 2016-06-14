package net.fl.greed;

public class SingleRule implements Rule {

  private int number;
  private int score;
  
  public SingleRule(int number, int score) {
    this.number = number;
    this.score = score;
  }
  
  public RuleResult apply(RuleResult previousResult) {
    int occurrencies = previousResult.occurrenciesOf(number);
    return previousResult
           .addScore(score * occurrencies)
           .removeOccurrencies(occurrencies, number);
  }
}
