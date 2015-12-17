package edu.wmich.cs.maccreery.ast;

public class LoadIInstruction extends IlocInstruction
{
  private ImmediateOperand constant;
  private VirtualRegisterOperand virtReg;

  public LoadIInstruction(ImmediateOperand constant, VirtualRegisterOperand virtReg) {
    this.constant = constant;
    this.virtReg = virtReg;
  }

  public VirtualRegisterOperand getDestinationRegister() { return this.virtReg; }

  public void setDestinationRegister(int r) { this.virtReg = new VirtualRegisterOperand(r); }

  public Integer compile(Object ... args) {
    StringBuilder instructions = (StringBuilder) args[0];

    if (constant instanceof LabelOperand) {
      instructions.append(String.format("\tleaq\tL_%s(%%rip), %%rsi\n", ((LabelOperand) constant).getImage()));
    } else {
      instructions.append(String.format("", ((ConstantOperand) constant).getImmediate()));
    }

    return 0;
  }
}
