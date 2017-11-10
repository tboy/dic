package com.base.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.user.User;
import com.spring.user.UserService;

@Controller
public class BaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin/test.htm")
	public ModelAndView test(HttpServletRequest req, HttpServletResponse res) {
		    System.out.println("go");
		    ModelAndView mv = getView("/test");
		    mv.addObject("go", "asdfasdf");
		    User u = userService.getObjById(1L);
            return mv;
            
	}

	public ModelAndView getView(String path) {
          ModelAndView mv = new ModelAndView(path);
          return mv;
	}
}
