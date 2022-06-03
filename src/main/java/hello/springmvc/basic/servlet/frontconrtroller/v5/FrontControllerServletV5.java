package hello.springmvc.basic.servlet.frontconrtroller.v5;


import hello.springmvc.basic.servlet.frontconrtroller.ModelView;
import hello.springmvc.basic.servlet.frontconrtroller.MyView;
import hello.springmvc.basic.servlet.frontconrtroller.v3.MemberFormControllerV3;
import hello.springmvc.basic.servlet.frontconrtroller.v4.MemberFormControllerV4;
import hello.springmvc.basic.servlet.frontconrtroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.springmvc.basic.servlet.frontconrtroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapter();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("front-controller/v5/v3/members/new-from", new MemberFormControllerV3());
        handlerMappingMap.put("front-controller/v5/v3/members/save", new MemberFormControllerV3());
        handlerMappingMap.put("front-controller/v5/v3/members", new MemberFormControllerV3());

        handlerMappingMap.put("front-controller/v5/v4/members/new-from", new MemberFormControllerV4());
        handlerMappingMap.put("front-controller/v5/v4/members/save", new MemberFormControllerV4());
        handlerMappingMap.put("front-controller/v5/v4/members", new MemberFormControllerV4());
    }

    private void initHandlerAdapter() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);

        MyView view = viewResolver((mv.getViewName()));
        view.render(mv.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)) {
                return adapter;
            }
        }

        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler= " + handler);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
