package edu.wmich.cs.maccreery.ast;

public class IlocInstruction<T>
{
  private int sourceLine = 0;
  private String label = "";

  public void setSourceLine(int sourceLine) {
    this.sourceLine = sourceLine;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public T compile(Object ... args) {
    return null;
  }

  public VirtualRegisterOperand getSourceRegister1() {
    return null;
  }

  public VirtualRegisterOperand getSourceRegister2() {
    return null;
  }

  public VirtualRegisterOperand getDestinationRegister() {
    return null;
  }
}
