package com.example.springtutorial.contoller;

import com.example.springtutorial.domain.Member;
import com.example.springtutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MemberController {
    private final MemberService memberService;

    // 맴버 컨트롤러 말고 다른 여러 컨트롤러들이 맴버서비스를 가져다가 쓸 수 있음
    // 스프링 컨테이너에서 쓸 때 생성자를 호출함
    // @Autowired가 있으면 맴버 서비스를 스프링이
    // 스프링 컨테이너에 있는 맴버 서비스를 가져다가 연결을 시켜줌
    // 스프링이 올라가고 조립이 됨
    @Autowired
    public MemberController(MemberService memberService){ //생성자를 통해서
        this.memberService = memberService;//맴버 컨트롤러
    }
    // 스프링 빈에 등록되어있는 객체를 넣어줌(DI)

    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        try{
            memberService.join(member);
        }catch (Exception e){
            return "redirect:/";
        }
        return "redirect:/";
    }
    @GetMapping("members")
    public String memberList(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);//members 안에는 memberlist가 담겨있음
        return "members/list";
    }
}
//Spring container가 생김 Controller라는 어노테이션을 보고 container에 집어넣음