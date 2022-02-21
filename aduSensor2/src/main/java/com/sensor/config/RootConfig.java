package com.sensor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;


@Configuration
@ComponentScan(basePackages = {"com.sensor"}, useDefaultFilters=false,
includeFilters = {
		@Filter(
		        type = FilterType.ANNOTATION,
		        classes = {Component.class, Repository.class, Service.class}
		    )
})
public class RootConfig {



}
