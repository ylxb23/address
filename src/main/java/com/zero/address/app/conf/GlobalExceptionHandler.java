package com.zero.address.app.conf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @date 2018年1月10日 下午5:51:02
 * @author zero
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 参数异常处理
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(produces= "application/json; charset=UTF-8")
	@ResponseBody
	@ExceptionHandler(value= {IllegalArgumentException.class})
	public ResponseEntity<?> illegalArgumentExceptionHander(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
		logger.error("illegalArgumentExceptionHander catch exception: ", e);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
	}
	
}
