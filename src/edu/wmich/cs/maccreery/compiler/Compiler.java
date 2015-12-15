package edu.wmich.cs.maccreery.compiler;

import edu.wmich.cs.maccreery.ast.*;

public class Compiler
{
  private StringBuilder instructions;
  private StringBuilder data;

  public Compiler(IlocProgram n) {
    instructions = new StringBuilder("");
    instructions.append("\t.globl\t_main\n"
                      + "_main:\n"
                      + "\tpushq\t%rbp\n"
                      + "\tmovq\t%rsp, %rbp\n");
    for (IlocInstruction i : n.getInstructions()) {
      i.compile(instructions);
    }
    instructions.append("\tpopq\t%rbp\n"
                      + "\tretq\n");

    data = new StringBuilder("");
    for (IlocInstruction i : n.getDataSection().getInstructions()) {
      i.compile(data);
    }

    System.out.println(instructions);
    System.out.print(data);
  }
}
