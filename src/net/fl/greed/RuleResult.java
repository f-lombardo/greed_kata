package net.fl.greed;

public class RuleResult {

  private final int score;
  private final Occurrencies occurrencies;

  public RuleResult(int score, Occurrencies occurrencies) {
    this.score = score;
    this.occurrencies = occurrencies;
  }

  public int score() {
    return score;
  }

  public int occurrenciesOf(int n) {
    return occurrencies.of(n);
  }

  public RuleResult addScore(int toAdd) {
    return new RuleResult(score + toAdd, occurrencies);
  }

  public RuleResult removeOccurrencies(int times, int number) {
    return new RuleResult(score, occurrencies.remove(times, number));
  }
}
