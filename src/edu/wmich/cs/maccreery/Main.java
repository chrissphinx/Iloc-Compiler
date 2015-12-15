package edu.wmich.cs.maccreery;

import edu.wmich.cs.maccreery.ast.IlocProgram;
import edu.wmich.cs.maccreery.parser.IlocParser;
import edu.wmich.cs.maccreery.parser.ParseException;
import edu.wmich.cs.maccreery.compiler.Compiler;

import java.io.*;

public class Main
{
  public static void main(String[] args) throws FileNotFoundException {
    if (args.length < 1) {
      System.err.println("usage: ilc <filename>");
    } else {
      IlocParser parser = new IlocParser(new FileReader(args[0]));
      IlocProgram program;

      try {
        Compiler compiler = new Compiler(IlocParser.program());
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
  }
}
