package hello.springmvc.basic.servlet.frontconrtroller.v3;

import hello.springmvc.basic.servlet.domain.member.Member;
import hello.springmvc.basic.servlet.domain.member.MemberRepository;
import hello.springmvc.basic.servlet.frontconrtroller.ModelView;

import java.util.Map;

/**
 * 회원 저장
 */
public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
