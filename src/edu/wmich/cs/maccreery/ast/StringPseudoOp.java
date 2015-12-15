package edu.wmich.cs.maccreery.ast;

public class StringPseudoOp extends IlocInstruction
{
  private String image;
  private String substring;

  public StringPseudoOp(String image, String substring) {
    this.image = image;
    this.substring = substring;
  }

  public Integer compile(Object ... args) {
    StringBuilder data = (StringBuilder) args[0];

    data.append(String.format("L_%s:\n\t.asciz\t\"%s\"\n\n", image, substring));

    return 0;
  }
}
