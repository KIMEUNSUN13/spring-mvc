package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @Controller
 *  반환값이 String이면, 어떤 뷰 이름으로 인식한다.
 *  그래서 뷰를 찾고 뷰가 렌더링된다.
 *
 *  @RestController
 *  반환 값으로 뷰를 찾는 것이 아니라,
 *  HTTP 메시지 바디에 바로 입력된다.
 *  @ResponseBody와 관련이 있다.
 */

@Slf4j
@RestController
public class LogTestController {
    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log{}", name);
        log.debug("debug log{}", name);
        log.info("info log{}", name);
        log.warn("warn log{}", name);
        log.error("error log{}", name);

        return "ok";
    }
}
