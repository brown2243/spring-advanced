package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
  private ThreadLocal<String> nameStore = new ThreadLocal<>();

  public void logic(String name) {
    log.info("저장 name={} -> store={}", name, nameStore.get());
    nameStore.set(name);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("조회 nameStore={}", nameStore.get());
  }
}
