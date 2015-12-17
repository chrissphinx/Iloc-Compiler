package edu.wmich.cs.maccreery.ast;

public class IreadInstruction extends IlocInstruction
{
  private VirtualRegisterOperand virtReg;

  public IreadInstruction(VirtualRegisterOperand virtReg) {
    super();
    this.virtReg = virtReg;
  }

  public VirtualRegisterOperand getSourceRegister1() {
    return this.virtReg;
  }

  public void setSourceRegister1(int r) {
    this.virtReg = new VirtualRegisterOperand(r);
  }

  public Integer compile(Object ... args) {
    return null;
  }
}
