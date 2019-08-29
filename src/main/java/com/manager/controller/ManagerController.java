package com.manager.controller;

import java.util.List;

import com.manager.dto.UserDto;
import com.manager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ManagerController{
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public ModelAndView openUserList() throws Exception{
        ModelAndView mv = new ModelAndView("/user/userList.html");
        // ModelAndView mv = new ModelAndView("/user/testInsertUser.html");

        List<UserDto> users = userService.selectUserList();
        mv.addObject("users", users);

        for(UserDto user : users) {
            log.info( user.getUserId() + "  " + user.getPass() );
        }

        return mv;
    }

   @RequestMapping(value = "/user/write", method = RequestMethod.POST)
   public String openUserWrite(UserDto userDto) throws Exception{
       log.info("...............................................???????????????????????");
       userService.insertUser(userDto);
       
       return "redirect:/user";
   }

    // @PathVariable 은 메서드의 파라미터가 URI의 변수로 사용되는 것을 의미
    @RequestMapping(value="/user/{userIdx}", method=RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("userIdx") int userIdx) throws Exception{
        userService.deleteUser(userIdx);
        return "redirect:/user";
    }
}