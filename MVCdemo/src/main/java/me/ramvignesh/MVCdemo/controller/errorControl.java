package me.ramvignesh.MVCdemo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class errorControl implements ErrorController  {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, ModelMap m) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String message="Are you even allowed to do that? (ಠ_ಠ)", code="000";
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	message = "Page not Found ¯\\_(ツ)_/¯";
	        	code = "404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	message = "Server went BAZINGA! (のへの)";
	        	code = "500";
	        }
	        else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
	        	message = "You sent me a Bad Request (ಠ_ಠ)";
	        	code = "400";
	        }
	        else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
	        	message = "Are you even allowed to use that method? (ಠ_ಠ)";
	        	code = "405";
	        }
	    }
		m.addAttribute("response", message);
		m.addAttribute("code", code);
	    return "error-code.jsp";
	}
	
	@Override
	public String getErrorPath() {
	    return null;
	}
}
