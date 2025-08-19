
package hello.advanced.app.v1;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

  private final OrderRepositoryV1 orderRepository;

  public void orderItem(String itemId) {
    orderRepository.save(itemId);
  }
}