package edu.wmich.cs.maccreery.ast;

public class VirtualRegisterOperand extends IlocInstruction
{
  private int register;

  public VirtualRegisterOperand(int register) {
    this.register = register;
  }

  public int getRegister() { return register; }

  public boolean equals(VirtualRegisterOperand v) {
    return this.register == v.getRegister();
  }
}
