package com.zulkarnaen.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

//	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) {
//		logger.info("Exception Occured:: URL=" + request.getRequestURL());
		System.out.println("Exception Occured:: URL=" + request.getRequestURL());

		ex.printStackTrace();
		return "error";
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException() {
		System.out.println("IOException handler executed");
//		logger.error("IOException handler executed");
		// returning 404 error code
	}
}