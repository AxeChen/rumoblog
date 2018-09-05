package com.rumo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.service.user.IUserService;
import com.rumo.vo.ServerResponse2;

/**
 * 登录Controller
 * 
 * @author 11373
 *
 */
@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	
	/**
	 * 跳转到log界面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@ResponseBody
	@PostMapping("/logined")
	public ServerResponse2 logined(@RequestParam("account")String account,@RequestParam("password")String password,
			HttpSession session) {
		ServerResponse2 serverResponse2 = userService.getLogin(account, password);
		if(serverResponse2.getStatus() == 200) {
			session.setAttribute("session_user", serverResponse2.getData());
			return ServerResponse2.createBySuccess();
		}else {
			return serverResponse2;
		}
	}
}
