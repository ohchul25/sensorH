package com.sensor.source.sensorData.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sensor.mapper.AbstractMapper;
import com.sensor.source.sensorData.model.SensorDataVO;

@Repository("SensorDataDao")
public class SensorDataDAO extends AbstractMapper {
	
	public List<SensorDataVO> selectUserList() {
		return selectList("selectUserList");
	}

}
