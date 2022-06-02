package hello.springmvc.basic.servlet.frontconrtroller.v2;

import hello.springmvc.basic.servlet.frontconrtroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 회원 등록 폼
 */
public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("WEB-INF/views/new-form.jsp");
    }
}
