package com.Hospital.core.action.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Controller
public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * Spring MVC 允许向整�?Spring 框架注册属�?编辑器，它们对所�?Controller 都有影响。当�?Spring MVC 也允许仅向某�?Controller 注册属�?编辑器，对其它的 Controller 没有影响。前者可以�?�?AnnotationMethodHandlerAdapter 的配置做到，而后者则可以通过 @InitBinder 注解实现�?	 * jack
	 * 2013-7-5
	 */
	@InitBinder
	protected void ininBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		logger.info("basecontroller:"+"BaseController.ininBinder");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}
	
	/**
	 * 获取request
	 * shhc
	 * 2013-7-5
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	

}
