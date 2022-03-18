package com.sensor.source.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sensor.source.menu.dao.MenuDAO;
import com.sensor.source.menu.model.MenuVO;
import com.sensor.source.menu.service.MenuService;

@Service("MenuService")
public class MenuServiceImpl implements MenuService{

	@Resource(name = "MenuDao")
	public MenuDAO menuDAO;
	
	@Override
	public List<MenuVO> getMnData() {
			
		return menuDAO.getMnData();
	}
	
	@Override
	public MenuVO selectDetail(String menuId) {
		
		return menuDAO.selectDetail(menuId);
	}
	

}
