/**
 *
 */
package com.sensor.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author 윤정욱
 *
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private DefaultListableBeanFactory defaultListableBeanFactory;

	/** Log */
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) throws Exception{
	
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler, ModelAndView modelAndView) throws Exception{
		if(modelAndView != null) {
			HttpSession session = request.getSession();

		}
	}

	// 메뉴코드로 메뉴명 가져오기
	public String getMenuNm(String menuId, String groupCode) throws Exception{
		String menuNm = "";

		return menuNm;
	}

	// 메뉴코드로 상위메뉴ID 가져오기
	public String getUpperMenuId(String menuId, String groupCode) throws Exception{
		String upperMenuId = "";


		return upperMenuId;
	}
}