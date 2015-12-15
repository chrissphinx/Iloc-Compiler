package edu.wmich.cs.maccreery.ast;

import java.util.Vector;

public class DataSection
{
  private Vector<IlocInstruction> instructions;

  public DataSection(Vector<IlocInstruction> instructions) {
    this.instructions = instructions;
  }

  public Vector<IlocInstruction> getInstructions() {
    return instructions;
  }
}
