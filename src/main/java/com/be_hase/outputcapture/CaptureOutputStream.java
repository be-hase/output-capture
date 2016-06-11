package com.be_hase.outputcapture;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CaptureOutputStream extends OutputStream {
    private final PrintStream original;

    private final OutputStream copy;

    CaptureOutputStream(PrintStream original, OutputStream copy) {
        this.original = original;
        this.copy = copy;
    }

    @Override
    public void write(int b) throws IOException {
        this.copy.write(b);
        this.original.write(b);
        this.original.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.copy.write(b, off, len);
        this.original.write(b, off, len);
    }

    public PrintStream getOriginal() {
        return this.original;
    }

    @Override
    public void flush() throws IOException {
        this.copy.flush();
        this.original.flush();
    }
}
