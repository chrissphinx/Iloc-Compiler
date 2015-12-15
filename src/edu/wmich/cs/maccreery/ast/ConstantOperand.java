package edu.wmich.cs.maccreery.ast;

public class ConstantOperand extends ImmediateOperand
{
  private int immediate;

  public ConstantOperand(int immediate) {
    this.immediate = immediate;
  }

  public int getImmediate() {
    return immediate;
  }
}
