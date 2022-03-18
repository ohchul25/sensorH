package com.sensor.source.sensorData.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensor.source.sensorData.model.SensorDataVO;
import com.sensor.source.sensorData.service.SensorDataService;

//@RequestMapping("")
@Controller
public class SensorDataController {
	
	@Resource(name = "SensorDataService")
	private SensorDataService sensorDataService;
	
	//목록 화면 이동
	@RequestMapping(value="/main.do" )
	public String callMainPage(ModelMap model) throws Exception{
		
		return "main/home";
	}
	
	//목록 화면 이동
	@RequestMapping(value="/selectUserList.do" )
	public String selectUserList(ModelMap model) throws Exception{
		
		List<SensorDataVO> list = sensorDataService.selectUserList();
		model.addAttribute("list",list);
		
		return "main/home";
	}
	
	//목록 화면 이동
	@RequestMapping(value = "/saveInfo", method = {RequestMethod.GET})
	public String saveInfo(ModelMap model){
		
		return "jsonView";
	}

}
