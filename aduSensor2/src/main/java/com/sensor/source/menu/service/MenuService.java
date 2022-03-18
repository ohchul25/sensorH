package com.sensor.source.menu.service;

import java.util.List;

import com.sensor.source.menu.model.MenuVO;

public interface MenuService {
	
	public List<MenuVO> getMnData();

	public MenuVO selectDetail(String menuId);
}
