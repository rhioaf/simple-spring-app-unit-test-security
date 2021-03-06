package com.xtremax.mainapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

  @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
  public String login(Model model) {
    return "/user/login";
  }
}
