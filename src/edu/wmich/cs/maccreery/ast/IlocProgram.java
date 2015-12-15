package edu.wmich.cs.maccreery.ast;

import java.util.Vector;

public class IlocProgram
{
  private DataSection dataSection;
  private Vector<IlocInstruction> instructions;
  private static int maxVirtualReg = 0;

  public IlocProgram(DataSection dataSection, Vector<IlocInstruction> instructions) {
    this.dataSection = dataSection;
    this.instructions = instructions;
  }

  public DataSection getDataSection() {
    return dataSection;
  }

  public Vector<IlocInstruction> getInstructions() {
    return instructions;
  }

  public static void setMaxVirtualReg(int max) {
    maxVirtualReg = max;
  }

  public static int getMaxVirtualReg() {
    return maxVirtualReg;
  }
}
