package com.PrjFrame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin() {
		logger.info("系统登录", "成功","admin", "1");
		return "../login";
	}

}
