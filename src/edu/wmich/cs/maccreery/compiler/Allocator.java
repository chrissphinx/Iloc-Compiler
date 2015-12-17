package edu.wmich.cs.maccreery.compiler;

import edu.wmich.cs.maccreery.ast.FramePseudoOp;
import edu.wmich.cs.maccreery.ast.IlocInstruction;
import edu.wmich.cs.maccreery.ast.VirtualRegisterOperand;

import java.util.List;
import java.util.Vector;

public class Allocator
{
  private Vector<IlocInstruction> block;
  private Register[] registers = new Register[8];

  public Allocator(Vector<IlocInstruction> block) {
    this.block = block;
    for (int i = 8; i < 16; i++)
      registers[i - 8] = new Register(i);
  }

  public void run() {
    int c = 0;

    for(IlocInstruction i : block) {
      if (i instanceof FramePseudoOp) continue;
      int rx = -1, ry = -1, rz = -1;

      if (i.getSourceRegister1() != null && i.getSourceRegister1().getRegister() != 0)
        rx = ensure(i.getSourceRegister1());
      if (i.getSourceRegister2() != null)
        ry = ensure(i.getSourceRegister2());

      if (i.getSourceRegister1() != null && i.getSourceRegister1().getRegister() != 0) {
        if (dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister1()) == Integer.MAX_VALUE) {
          free(rx);
        }
      }

      if (i.getSourceRegister2() != null) {
        if (dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister2()) == Integer.MAX_VALUE) {
          free(ry);
        }
      }

      if (i.getDestinationRegister() != null)
        rz = allocate(i.getDestinationRegister());

      if (rx != -1)
        i.setSourceRegister1(rx);
      if (ry != -1)
        i.setSourceRegister2(ry);
      if (rz != -1)
        i.setDestinationRegister(rz);

      if (i.getSourceRegister1() != null && i.getSourceRegister1().getRegister() != 0) {
        if (!(dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister1()) == Integer.MAX_VALUE)) {
          registers[rx - 8].next = dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister1());
        }
      }

      if (i.getSourceRegister2() != null) {
        if (!(dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister2()) == Integer.MAX_VALUE)) {
          registers[ry - 8].next = dist(block.subList(c + 1, block.size() - 1), i.getSourceRegister2());
        }
      }

      if (i.getDestinationRegister() != null) {
        registers[rz - 8].next = dist(block.subList(c + 1, block.size() - 1), i.getDestinationRegister());
      }

      c++;
    }
  }

  private int allocate(VirtualRegisterOperand v) {
    boolean free = false;

    int i = 8;
    for (Register r : registers) {
      if (r.free) {
        r.name = v;
        r.next = -1;
        r.free = false;
        return i;
      }
      i++;
    }

    // didn't find free register

    int current  = 0;
    int selected = 0;
    int j = 8;
    for (Register r : registers) {
      if (r.next > current)
        r.next = current;
        selected = j;
      j++;
    }

    // store contents of selected

    registers[selected].name = v;
    registers[selected].next = -1;
    registers[selected].free = false;

    return selected;
  }

  private int ensure(VirtualRegisterOperand v) {
    int i = 0;
    for (Register r : registers) {
      if (r.name.getRegister() == v.getRegister())
        return i + 8;
      i++;
    }

    int result = allocate(v);

    // emit code to move vr into result

    return result;
  }

  private void free(int r) {
    registers[r - 8].free = true;
  }

  private int dist(List<IlocInstruction> b, VirtualRegisterOperand v) {
    int c = 1;

    for(IlocInstruction i : b) {
      if ((i.getSourceRegister1() != null && i.getSourceRegister1().equals(v))
      || (i.getSourceRegister2() != null && i.getSourceRegister2().equals(v))
      || (i.getDestinationRegister() != null && i.getDestinationRegister().equals(v))) {
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
