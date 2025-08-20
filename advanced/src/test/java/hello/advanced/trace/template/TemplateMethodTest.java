package hello.advanced.trace.template;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {
  @Test
  void templateMethodV0() {
    logic1();
    logic2();
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

  /**
   * 템플릿 메서드 패턴 적용
   */
  @Test
  void templateMethodV1() {
    AbstractTemplate template1 = new SubClassLogic1();
    template1.execute();
    AbstractTemplate template2 = new SubClassLogic2();
    template2.execute();
  }

  /**
   * 템플릿 메서드 패턴,
   * 익명 내부
   * 클래스 사용
   */
  @Test
  void templateMethodV2() {
    AbstractTemplate template1 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비즈니스 로직1 실행");
      }
    };
    log.info("클래스 이름1={}", template1.getClass());
    template1.execute();
    AbstractTemplate template2 = new AbstractTemplate() {
      @Override
      protected void call() {
        log.info("비즈니스 로직1 실행");
      }
    };
    log.info("클래스 이름2={}", template2.getClass());
    template2.execute();
  }
}
