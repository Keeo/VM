package cz.cvut.fit.run.vm.runtime.instruction;

import cz.cvut.fit.run.vm.runtime.Frame;
import cz.cvut.fit.run.vm.runtime.operant.ValueInteger;
import sun.plugin2.applet.SecurityManagerHelper;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Stack;

/**
 * when docs are garbage
 * https://cs.au.dk/~mis/dOvs/jvmspec/ref--41.html
 * Created by Keo on 15.2.2017.
 */
public class LookupSwitch extends Instruction {
    // 38 33 124
    Hashtable<Integer, Integer> pairs = new Hashtable<>();
    int defaultAddress;

    public LookupSwitch(DataInputStream code, int pc) throws IOException {
        this.echo();

        while ((pc + 1) % 4 != 0) {
            pc++;
            byte padding = code.readByte();
            assert(padding == 0);
        }

        defaultAddress = code.readInt();
        int labels = code.readInt();

        for (int i = 0; i < labels; ++i) {
            int match = code.readInt();
            int label = code.readInt();
            pairs.put(match, label);
        }
    }

    @Override
    public void execute(Frame frame, Stack<Frame> stack) {
        ValueInteger value = (ValueInteger) frame.operandStack.pop();
        Integer jump = pairs.get(value.integer);
        if (jump == null) {
            frame.pc += defaultAddress;
        } else {
            frame.pc += jump;
        }
    }
}
