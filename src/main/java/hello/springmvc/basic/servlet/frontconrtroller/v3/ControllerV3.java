package hello.springmvc.basic.servlet.frontconrtroller.v3;

import hello.springmvc.basic.servlet.frontconrtroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
