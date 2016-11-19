public abstract Node {
public abstract int getVal();
}
public NumNode extends Node {
  Token val;
  public int getVal () {
      return val.getNumber();
  }
}
public OpNode extends Node {
  Node left;
  Node right;
  Token op;
  public int getVal () throw Exceptin {
    String cur = op.getText();
    if (cur.equals("+")) {
      return left.getVal() + right.getVal();
    } else if (cur.equals("*")) {
      return left.getVal() * right.getVal();
    } else {
      throw new Excepton("bad operator " + cur);
    }
  }
}
