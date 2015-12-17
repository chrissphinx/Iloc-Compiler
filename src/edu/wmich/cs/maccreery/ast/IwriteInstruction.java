package edu.wmich.cs.maccreery.ast;

public class IwriteInstruction extends IlocInstruction
{
  private VirtualRegisterOperand virtReg;

  public IwriteInstruction(VirtualRegisterOperand vr1) {
    super();
    this.virtReg = vr1;
  }

  public VirtualRegisterOperand getSourceRegister1() {
    return this.virtReg;
  }

  public void setSourceRegister1(int r) { this.virtReg = new VirtualRegisterOperand(r); }

  public Integer compile(Object ... args) {
    return null;
  }
}
