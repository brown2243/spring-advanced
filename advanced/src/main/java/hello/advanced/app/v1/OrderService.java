
package hello.advanced.app.v1;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public void orderItem(String itemId) {
    orderRepository.save(itemId);
  }
}