package edu.wmich.cs.maccreery.ast;

public class LabelOperand extends ImmediateOperand
{
  private String image;

  public LabelOperand(String image) {
    this.image = image;
  }

  public String getImage() { return image; }
}
