package com.superface.example.controller;

import com.superface.example.entity.User;
import com.superface.example.util.MD5Utils;
import com.superface.example.web.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
	public Response login(String username, String password,Boolean rememberMe) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return Response.ok();
		} catch (UnknownAccountException e) {
			return Response.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return Response.error(e.getMessage());
		} catch (LockedAccountException e) {
			return Response.error(e.getMessage());
		} catch (AuthenticationException e) {
			return Response.error("认证失败！");
		}
	}

	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/403")
	public String forbid() {
		return "403";
	}
}