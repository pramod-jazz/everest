package com.examples.monolith.everest_replatform.uzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UzerController {

    @Autowired
    UzerBean userBean;

    @GetMapping("user")
    public String displayUserLanding(){
        return "user";
    }

    @PostMapping("user")
    public ModelAndView saveUser(UzerItem uzerItem){
        userBean.addUzer(uzerItem);
        ModelAndView model = new ModelAndView("user-status");
        model.addObject("status",userBean.getStatus());
        return model;
    }


}
