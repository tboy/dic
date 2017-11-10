package com.spring.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAction {
     @Autowired
     private UserService service;
	 /** 
     * 登录 
     * @param session 
     *          HttpSession 
     * @param username 
     *          用户名 
     * @param password 
     *          密码 
     * @return 
     */  
    @RequestMapping(value="/login")  
    public ModelAndView login(HttpServletRequest req ,HttpServletResponse res, String username,String password){        
      
    	   /*String sql ="insert into user(userName) values ('yyyyyyyy'),('hhhhhhhh')";
    	   this.service.cuDao().updateBySql(sql, null, -1, -1);
    	  //List<User> rs = this.service.list(hql, params, -1, -1);
    	  //System.out.println(rs);
    	   * 
    	   */
    	
    	  String hql = " from User ";
    	  //List rs = this.service.list(hql, null, -1, -1);
          ModelAndView mv = new ModelAndView("views/login");
         //// mv.addObject("val", "asdfasdf");
         // mv.addObject("list",rs);
           // throw new Error("123123");
           //重定向  
          return mv;
    }  
      
    /** 
     * 退出系统 
     * @param session 
     *          Session 
     * @return 
     * @throws Exception 
     */  
    @RequestMapping(value="/logout")  
    public String logout(HttpServletRequest req ,HttpServletResponse res) throws Exception{  
        //清除Session  
        req.getSession().invalidate();   
        return "redirect:hello.action";  
    }  
}
