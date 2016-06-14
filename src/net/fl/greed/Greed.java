package net.fl.greed;

import java.util.*;

public class Greed {
  
  private ArrayList<Rule> rules;

  public Greed() {
    rules = new ArrayList<Rule>();
    rules.add(new ThreeItemsRule());
    rules.add(new SingleRule(1, 100));
    rules.add(new SingleRule(5, 50));
  }

  public int score(List<Integer> dice) {
    RuleResult result = new RuleResult(0, new Occurrencies(dice));
    for(Rule rule: rules) {
      result = rule.apply(result);
    }
    return result.score();
  }

}
