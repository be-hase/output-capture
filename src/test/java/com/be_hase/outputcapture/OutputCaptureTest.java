package com.be_hase.outputcapture;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class OutputCaptureTest {
    @Rule
    public OutputCapture capture = new OutputCapture();

    @Test
    public void test() {
        System.out.println("hoge");
        System.out.println("bar");
        System.out.println("~!@#$%^&*()_+");
        System.out.println("あいうえお");

        assertThat(capture.toString(), containsString("hoge"));
        assertThat(capture.toString(), containsString("bar"));
        assertThat(capture.toString(), containsString("~!@#$%^&*()_+"));
        assertThat(capture.toString(), containsString("あいうえお"));
    }

    @Test
    public void expect() {
        System.out.println("hoge");
        System.out.println("bar");
        System.out.println("~!@#$%^&*()_+");
        System.out.println("あいうえお");

        capture.expect(containsString("hoge"));
        capture.expect(containsString("bar"));
        capture.expect(containsString("~!@#$%^&*()_+"));
        capture.expect(containsString("あいうえお"));
    }
}