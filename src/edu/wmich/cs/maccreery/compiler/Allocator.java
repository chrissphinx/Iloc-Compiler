package edu.wmich.cs.maccreery.compiler;

import edu.wmich.cs.maccreery.ast.IlocInstruction;
import edu.wmich.cs.maccreery.ast.VirtualRegisterOperand;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Allocator
{
  private Vector<IlocInstruction> block;
  private ArrayList<Register> registers;

  public Allocator(Vector<IlocInstruction> block) {
    this.block = block;
    for (int i = 8; i < 16; i++)
      registers.add(new Register(i));
  }

  public void run() {
    int c = 0;

    for(IlocInstruction i : block) {
      int rx, ry, rz;

      if (i.getSourceRegister1() != null)
        rx = ensure(i.getSourceRegister1());
      if (i.getSourceRegister2() != null)
        ry = ensure(i.getSourceRegister2());

      if (dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister1()) == Integer.MAX_VALUE)
        free();
      if (dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister2()) == Integer.MAX_VALUE)
        free();

      if (i.getDestinationRegister() != null)
        rz = allocate(i.getDestinationRegister());


      c++;
    }
  }

  private void allocate(VirtualRegisterOperand v) {

  }

  private void ensure(VirtualRegisterOperand v) {

  }

  private void free(int r) {
    registers.add(r);
  }

  private int dist(List<IlocInstruction> b, VirtualRegisterOperand v) {
    int c = 1;

    for(IlocInstruction i : b) {
      if (i.getSourceRegister1().equals(v)
       || i.getSourceRegister2().equals(v)
       || i.getDestinationRegister().equals(v)) {
        return c;
      }
      c++;
    }

    return Integer.MAX_VALUE;
  }

  private class Register {
    protected VirtualRegisterOperand name;
    protected int next;
    protected boolean free;

    public Register(int n) {
      this.name = new VirtualRegisterOperand(n);
      this.next = Integer.MAX_VALUE;
      this.free = true;
    }
  }
}
