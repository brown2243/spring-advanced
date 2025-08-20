package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {
  @Test
  void testV0() {
    logic1();
    logic2();
  }

  @Test
  void testV1() {
    ContextV1 context1 = new ContextV1(new StrategyLogic1());
    ContextV1 context2 = new ContextV1(new StrategyLogic2());

    context1.execute();
    context2.execute();
  }

  @Test
  void testV2() {
    Strategy strategy1 = new Strategy() {
      @Override
      public void call() {
        log.info("비즈니스 로직1 실행");
      }
    };
    Strategy strategy2 = new Strategy() {
      @Override
      public void call() {
        log.info("비즈니스 로직2 실행");
      }
    };

    ContextV1 context1 = new ContextV1(strategy1);
    ContextV1 context2 = new ContextV1(strategy2);

    context1.execute();
    context2.execute();
  }

  @Test
  void testV3() {
    ContextV1 context1 = new ContextV1(new Strategy() {
      @Override
      public void call() {
        log.info("비즈니스 로직1 실행");
      }
    });
    ContextV1 context2 = new ContextV1(new Strategy() {
      @Override
      public void call() {
        log.info("비즈니스 로직2 실행");
      }
    });
    context1.execute();
    context2.execute();
  }

  @Test
  void testV4() {
    ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
    ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
    context1.execute();
    context2.execute();
  }

  void logic1() {
    Long startTime = System.currentTimeMillis();
    // logic start
    log.info("로직1 시작");
    // logic end
    Long endTime = System.currentTimeMillis();
    log.info("소요 시간 {}", endTime - startTime);
  }

  void logic2() {
    Long startTime = System.currentTimeMillis();
    // logic start
    log.info("로직2 시작");
    // logic end
    Long endTime = System.currentTimeMillis();
    log.info("소요 시간 {}", endTime - startTime);
  }

}
