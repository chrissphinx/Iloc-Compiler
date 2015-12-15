package edu.wmich.cs.maccreery.ast;

public class AddInstruction extends IlocInstruction
{
  private VirtualRegisterOperand[] virtRegs;

  public AddInstruction(VirtualRegisterOperand vr1, VirtualRegisterOperand vr2, VirtualRegisterOperand vr3) {
    super();
    this.virtRegs[0] = vr1;
    this.virtRegs[1] = vr2;
    this.virtRegs[2] = vr3;
  }

  public Integer compile(Object ... args) {
    return null;
  }
}
