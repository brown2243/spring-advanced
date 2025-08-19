package hello.advanced.app.v3;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
  private final LogTrace trace;

  public void save(String itemId) {
    trace.begin("OrderRepository.save()");
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
