package com.example.springtutorial.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hel1o");
        return "hello/hello";
    }

    @GetMapping("hello-mvc") //getMapping 안에 있는게 엔드포인트
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);//attributeName이 파라미터,넘겨줄 파라미터값
            return "hello-template";//return 값이 pebble 경로(template 안에 있는)
    }
    @GetMapping("hello-string")
    @ResponseBody

    public String helloString(@RequestParam("name") String name){
        return "hello " + name;//hello spring
    }
    @GetMapping("hello-api")
    @ResponseBody

    //이게 붙어있으면 바로 http 응답에 던짐 viewResolver대신에 httpMessageCoverter가 동작
    public Hello helloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//이게 객체면 json형태로 반환
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

//정적 컨텐츠 - 그냥 파일을 내려준다
//템플릿 엔진 - 템플릿 엔진을 mvc로 프로그래밍 한 걸로 랜더링해서 그 html을 전달해줌
//api - 객체를 response해준다