package com.sensor.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.sensor.interceptor.CommonInterceptor;

import org.springframework.stereotype.Controller;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sensor"}
,
includeFilters = {
		@Filter(
		        type = FilterType.ANNOTATION,
		        classes = {Controller.class}
		    )
},
useDefaultFilters=false)
public class ServletConfig implements WebMvcConfigurer {	// view resolver, resource handler, 

	private static final int CACHE_PERIOD = 259200; // one month
	private final int MAX_SIZE = 1000 * 1024 * 1024;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.viewResolver(new TilesViewResolver());
        registry.viewResolver(new BeanNameViewResolver());
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	@Bean
	public CommonInterceptor commonInterceptor() {
		System.err.println(1);
		return new CommonInterceptor();
	}

    /**
     * 언어 변경을 위한 인터셉터를 생성한다.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }


}
