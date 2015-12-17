package edu.wmich.cs.maccreery.ast;

public class StoreInstruction extends IlocInstruction
{
  private VirtualRegisterOperand[] virtRegs;

  public StoreInstruction(VirtualRegisterOperand v1, VirtualRegisterOperand v3) {
    super();
    this.virtRegs = new VirtualRegisterOperand[2];
    this.virtRegs[0] = v1;
    this.virtRegs[1] = v3;
  }

  public VirtualRegisterOperand getSourceRegister1() {
    return this.virtRegs[0];
  }

  public void setSourceRegister1(int r) { this.virtRegs[0] = new VirtualRegisterOperand(r); }

  public VirtualRegisterOperand getDestinationRegister() {
    return this.virtRegs[1];
  }

  public void setDestinationRegister(int r) { this.virtRegs[1] = new VirtualRegisterOperand(r); }

  public Integer compile(Object ... args) {
    return null;
  }
}
