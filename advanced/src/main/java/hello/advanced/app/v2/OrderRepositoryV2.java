package hello.advanced.app.v2;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
  private final HelloTraceV2 trace;

  public void save(TraceId traceId, String itemId) {
    trace.beginSync(traceId, "OrderRepository.save()");
    if (itemId.equals("ex")) {
      throw new IllegalStateException("예외 발생");
    }
    sleep(1000);
  }

  private void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
