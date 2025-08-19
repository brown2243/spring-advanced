package hello.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;

public class HelloTraceV1Test {

	@Test
	public void begin_end() {
		HelloTraceV1 helloTrace = new HelloTraceV1();
		TraceStatus status = helloTrace.begin("test");
		helloTrace.end(status);
	}

	@Test
	public void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("test");
		trace.exception(status, new IllegalStateException("sth"));
	}
}
