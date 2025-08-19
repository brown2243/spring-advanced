
package hello.advanced.app.v2;

import org.springframework.stereotype.Service;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
  private final HelloTraceV2 trace;
  private final OrderRepositoryV2 orderRepository;

  public void orderItem(TraceId traceId, String itemId) {
    trace.beginSync(traceId, "OrderService.orderItem()");
    orderRepository.save(traceId, itemId);
  }
}