package com.dingjianlei.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobleExceptionHandle {
	private static final String defalut = "error";
	@ExceptionHandler(value = Exception.class)
public ModelAndView handle(HttpServletRequest req, Exception e) {
ModelAndView mav =new ModelAndView();
mav.addObject("user", "dingjianlei");
mav.addObject("url", req.getRequestURL());
mav.setViewName(defalut);
		return mav;
	}
}
