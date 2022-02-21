package com.sensor.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.jsp.jstl.core.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;


public class WebInitializer implements WebApplicationInitializer{

	private static final Logger LOGGER = LoggerFactory.getLogger(WebInitializer.class);

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		LOGGER.debug("========================WebApplicationInitializer START========================");
		
		// Root Context 지정
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        
        // Dispatcher Servlet 추가
        this.addDispatcherServlet(servletContext);
        
        // UTF-8 변환 필터 추가
        this.addUtf8CharacterEncodingFilter(servletContext);
        
        // xss
        // this.addXssFilter(servletContext);
    }

    private void addDispatcherServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ServletConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
            new DispatcherServlet(applicationContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private void addUtf8CharacterEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("CHARACTER_ENCODING_FILTER",
            CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
        //filter.addMappingForUrlPatterns(null, false, "/*");
        filter.addMappingForUrlPatterns(null, false, "*.do");
    }

    private void addMultipartFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic filter = servletContext.addFilter("MULTIPART_FILTER",
        		MultipartFilter.class);
        filter.addMappingForUrlPatterns(null, false, "*.do");
    }

}
