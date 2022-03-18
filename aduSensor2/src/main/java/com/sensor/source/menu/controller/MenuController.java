package com.sensor.source.menu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensor.source.menu.model.MenuVO;
import com.sensor.source.menu.service.MenuService;

@RequestMapping("/menu/")
@Controller
public class MenuController {
	
	@Resource(name = "MenuService")
	private MenuService menuService;
	
	//목록 화면 이동
	@RequestMapping(value="/moveMnPage.do" )
	public String moveMnPage(ModelMap model) throws Exception{
		
		return "menu/menuList";
	}
	
	//목록 화면 이동
	@RequestMapping(value="/getMnData.do" )
	public String getMnData(ModelMap model) throws Exception{
		
		List<MenuVO> list = menuService.getMnData();
		
		model.addAttribute("list", list);
		
		return "jsonView";
	}
	
	//목록 화면 이동
	@RequestMapping(value="/selectDetail.do" )
	public String selectDetail(ModelMap model, @RequestBody MenuVO menuVO) throws Exception{
		
		MenuVO list = menuService.selectDetail(menuVO.getMenuId());
		
		model.addAttribute("list", list);
		
		return "jsonView";
	}
	

}
