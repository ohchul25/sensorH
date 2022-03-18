package com.sensor.source.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sensor.mapper.AbstractMapper;
import com.sensor.source.menu.model.MenuVO;

@Repository("MenuDao")
public class MenuDAO extends AbstractMapper {
	
	public List<MenuVO> getMnData() {
		return selectList("selectMnList");
	}
	
	public MenuVO selectDetail(String menuId) {
		return selectOne("selectDetail", menuId);
	}

}
