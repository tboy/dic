package com.base.action;

import org.springframework.web.servlet.ModelAndView;

public class BaseAction {
   public ModelAndView getView(String path){
	   ModelAndView mv = new ModelAndView(path);
	   mv.addObject("webPath","http://localhost:8080/old");
	   return mv;
   }
}
