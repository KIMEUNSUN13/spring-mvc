package hello.springmvc.basic.servlet.frontconrtroller.v3;

import hello.springmvc.basic.servlet.domain.member.Member;
import hello.springmvc.basic.servlet.domain.member.MemberRepository;
import hello.springmvc.basic.servlet.frontconrtroller.ModelView;

import java.util.List;
import java.util.Map;

/**
 * 회원 목록
 */
public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
