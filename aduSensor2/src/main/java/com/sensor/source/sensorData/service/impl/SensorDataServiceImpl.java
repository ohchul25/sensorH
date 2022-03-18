package com.sensor.source.sensorData.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sensor.source.sensorData.dao.SensorDataDAO;
import com.sensor.source.sensorData.model.SensorDataVO;
import com.sensor.source.sensorData.service.SensorDataService;

@Service("SensorDataService")
public class SensorDataServiceImpl implements SensorDataService{

	@Resource(name = "SensorDataDao")
	public SensorDataDAO sensorDataDAO;
	
	@Override
	public List<SensorDataVO> selectUserList() {
			
		return sensorDataDAO.selectUserList();
	}
	

}
