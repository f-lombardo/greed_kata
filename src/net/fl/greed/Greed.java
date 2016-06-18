package net.fl.greed;

import java.util.*;

public class Greed {
  
  private ArrayList<Rule> rules;

  public Greed() {
    rules = new ArrayList<Rule>();
    rules.add(new NItemsRule(1, 1000, 3));
    for (int i = 2; i <= 6; i++) {
      rules.add(new NItemsRule(i, i * 100, 3));
    }
    rules.add(new NItemsRule(1, 200, 2));
    rules.add(new NItemsRule(5, 100, 2));
    rules.add(new NItemsRule(1, 100, 1));
    rules.add(new NItemsRule(5, 50, 1));
  }

  public int score(List<Integer> dice) {
    RuleResult result = new RuleResult(0, new Occurrencies(dice));
    for(Rule rule: rules) {
      result = rule.apply(result);
    }
    return result.score();
  }

}
