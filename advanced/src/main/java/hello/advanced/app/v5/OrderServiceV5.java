package hello.advanced.app.v5;

import org.springframework.stereotype.Service;

import hello.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
  private final TraceTemplate traceTemplate;
  private final OrderRepositoryV5 orderRepository;

  public void orderItem(String itemId) {
    traceTemplate.execute("OrderService.orderItem()", () -> {
      orderRepository.save(itemId);
      return null;
    });
  }
}