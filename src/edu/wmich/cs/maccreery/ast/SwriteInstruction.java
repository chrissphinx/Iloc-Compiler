package edu.wmich.cs.maccreery.ast;

public class SwriteInstruction extends IlocInstruction
{
  private VirtualRegisterOperand virtReg;

  public SwriteInstruction(VirtualRegisterOperand virtReg) {
    super();
    this.virtReg = virtReg;
  }

  public Integer compile(Object ... args) {
    StringBuilder instructions = (StringBuilder) args[0];

    instructions.append("\tleaq\tL_.string_wformat(%rip), %rdi\n");
    instructions.append("\tcallq\t_printf\n");

    return 0;
  }
}
