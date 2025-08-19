
package hello.advanced.app.v3;

import org.springframework.stereotype.Service;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
  private final LogTrace trace;
  private final OrderRepositoryV3 orderRepository;

  public void orderItem(String itemId) {
    trace.begin("OrderService.orderItem()");
    orderRepository.save(itemId);
  }
}