package edu.wmich.cs.maccreery.ast;

public class AndInstruction extends IlocInstruction
{
  private VirtualRegisterOperand[] virtRegs;

  public AndInstruction(VirtualRegisterOperand vr1, VirtualRegisterOperand vr2, VirtualRegisterOperand vr3) {
    super();
    virtRegs = new VirtualRegisterOperand[3];
    this.virtRegs[0] = vr1;
    this.virtRegs[1] = vr2;
    this.virtRegs[2] = vr3;
  }

  public VirtualRegisterOperand getSourceRegister1() {
    return this.virtRegs[0];
  }

  public void setSourceRegister1(int r) { this.virtRegs[0] = new VirtualRegisterOperand(r); }

  public VirtualRegisterOperand getSourceRegister2() {
    return this.virtRegs[1];
  }

  public void setSourceRegister2(int r) { this.virtRegs[1] = new VirtualRegisterOperand(r); }

  public VirtualRegisterOperand getDestinationRegister() {
    return this.virtRegs[2];
  }

  public void setDestinationRegister(int r) { this.virtRegs[2] = new VirtualRegisterOperand(r); }

  public Integer compile(Object ... args) {
    return null;
  }
}
