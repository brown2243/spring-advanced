package hello.advanced.app.v5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {
  private final OrderServiceV5 orderService;
  private final TraceTemplate traceTemplate;

  @GetMapping("/v5/request")
  public String request(@RequestParam String itemId) {
    return traceTemplate.execute("OrderController.request()", () -> {
      orderService.orderItem(itemId);
      return "ok";
    });
  }
}