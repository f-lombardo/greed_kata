package net.fl.greed;


public interface ScoringStrategy {
  public int score(int toFind);
  
  public final static ScoringStrategy MULTYPLY_NR = new ScoringStrategy() {
    public int score(int toFind) {
      return toFind * 100;
    }
  };
  
  public final static ScoringStrategy CONST_VALUE = new ScoringStrategy() {
    public int score(int toFind) {
      return 1000;
    }
  };
}
