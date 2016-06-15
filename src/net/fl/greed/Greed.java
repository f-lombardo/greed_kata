package net.fl.greed;

import java.util.*;

public class Greed {
  
  private ArrayList<Rule> rules;

  public Greed() {
    rules = new ArrayList<Rule>();
    rules.add(new ThreeItemsRule(1, ScoringStrategy.CONST_VALUE));
    for (int i = 2; i <= 6; i++) {
      rules.add(new ThreeItemsRule(i, ScoringStrategy.MULTYPLY_NR));
    }
    rules.add(new SingleItemRule(1, 100));
    rules.add(new SingleItemRule(5, 50));
  }

  public int score(List<Integer> dice) {
    RuleResult result = new RuleResult(0, new Occurrencies(dice));
    for(Rule rule: rules) {
      result = rule.apply(result);
    }
    return result.score();
  }

}
