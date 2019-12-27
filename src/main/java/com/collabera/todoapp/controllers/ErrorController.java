package com.collabera.todoapp.controllers;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	

	@ExceptionHandler(FileNotFoundException.class)
	public ModelAndView fileNotFoundErrorHandler(HttpServletRequest req,
			Exception ex) {
		
		ModelAndView mav= new ModelAndView();
		
		mav.addObject("Exception",ex.getStackTrace());
		mav.addObject("Url", req.getRequestURL());
		
		System.out.println(req.getRequestURL());
		mav.setViewName("error");;
		
		
		return mav;
	}

	// dispatcher servlet gets ann exception
	@ExceptionHandler(Exception.class)
	public ModelAndView errorHandler(HttpServletRequest req,
			Exception ex) {
		
		ModelAndView mav= new ModelAndView();
		
		mav.addObject("Exception",ex.getStackTrace());
		mav.addObject("Url", req.getRequestURL());
		System.out.println(req.getRequestURL());
		mav.setViewName("error");
		
		
		return mav;
	}
}
