package hello.springmvc.basic.servlet.frontconrtroller.v3;

import hello.springmvc.basic.servlet.frontconrtroller.ModelView;

import java.util.Map;

/**
 * 회원 등록 폼
 */
public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
