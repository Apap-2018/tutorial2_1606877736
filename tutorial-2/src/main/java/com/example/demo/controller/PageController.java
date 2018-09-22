package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PageController {

    @RequestMapping("/viral")
    public String index(){
        return "viral";
    }

    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value="name") String name, Model model){
        model.addAttribute("name", name);
        return "challenge";
    }


    @RequestMapping(value = {"/challenge/","challenge/{name}"})
    public String challengePath(@PathVariable Optional<String> name, Model model){
        if (name.isPresent()){
            model.addAttribute("name",name);
        } else {
            model.addAttribute("name", "KB");
        }
        return "challenge";
    }

    @RequestMapping("/generator")
    public String challenge(@RequestParam(value="a", required = false, defaultValue = "0") int a, @RequestParam(value="b", required = false, defaultValue = "0") int b, Model model){
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("hm","hm");
        String strHm = "hm";
        while(a > 1) {
            strHm += "m";
            a--;
        }
        if(b < 1){
            model.addAttribute("hm", strHm);
        }else {
            String strHsl = "";
            while(b >= 1){
                strHsl += " " + strHm;
                b--;
            }
            model.addAttribute("hm", strHsl);
        }

        return "generator";
    }

}
