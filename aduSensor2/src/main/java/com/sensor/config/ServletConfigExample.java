//package com.sensor.config;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.view.BeanNameViewResolver;
//import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
//import org.springframework.stereotype.Controller;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.sensor"}
//,
//includeFilters = {
//		@Filter(
//		        type = FilterType.ANNOTATION,
//		        classes = {Controller.class}
//		    )
//},
//useDefaultFilters=false)
//public class ServletConfigExample implements WebMvcConfigurer {	// view resolver, resource handler, 
//
//	private static final int CACHE_PERIOD = 259200; // one month
//	private final int MAX_SIZE = 1000 * 1024 * 1024;
//
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(new TilesViewResolver());
//        registry.viewResolver(new BeanNameViewResolver());
//		registry.enableContentNegotiation(new MappingJackson2JsonView());
//		registry.jsp("/WEB-INF/views/",".jsp");
//
//	}
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Static ressources from both WEB-INF and webjars
//        //registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/images/**").addResourceLocations("/static/images/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/fonts/**").addResourceLocations("/static/fonts/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/html/**").addResourceLocations("/static/html/").setCachePeriod(CACHE_PERIOD);
////        registry.addResourceHandler("/excel/**").addResourceLocations("/static/excel/").setCachePeriod(CACHE_PERIOD);
//    }
//
//    /**
//     * 언어 변경을 위한 인터셉터를 생성한다.
//     */
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        return interceptor;
//    }
////
////    @Bean
////    public CommonInterceptor commonInterceptor() {
////    	return new CommonInterceptor();
////    }
////    /**
////     * 인터셉터를 등록한다.
////     */
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(localeChangeInterceptor());
////        //registry.addInterceptor(new LocaleInterceptor());
////        registry.addInterceptor(commonInterceptor())
////        	.addPathPatterns("/**/*.do")
////        	.excludePathPatterns("/ErrorAjax.do")
////        	.excludePathPatterns("/ErrorAuthAjax.do")
////        	.excludePathPatterns("/common/*.do")
////        	.excludePathPatterns("/Login.do")
////        	.excludePathPatterns("/LoginProc.do")
////        	.excludePathPatterns("/SmsAuthSave.do")
////        	.excludePathPatterns("/ChkAuthCode.do")
////        	.excludePathPatterns("/LoginSucc.do")
////        	.excludePathPatterns("/LoginOut.do")
////        	.excludePathPatterns("/PasswordChange.do")
////        	.excludePathPatterns("/PageMvmn.do")
////        	.excludePathPatterns("/android/checkplus.do")
////        	.excludePathPatterns("/ios/checkplus.do")
////        	.excludePathPatterns("/android/checkplusSuccess.do")
////        	.excludePathPatterns("/ios/checkplusSuccess.do")
////        	.excludePathPatterns("/android/checkplusFail.do")
////        	.excludePathPatterns("/ios/checkplusFail.do");
////    }
//
////    @Bean
////	public MappingJackson2JsonView jsonView() {
////    	MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
////    	jsonView.setContentType("application/json; charset=UTF-8");
////		return jsonView;
////	}
//
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//    	final TilesConfigurer configurer = new TilesConfigurer();
//    	configurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml"});
//    	configurer.setCheckRefresh(true);
//    	return configurer;
//    }
//
////    @Bean
////	public TilesViewResolver tilesViewResolver() {
////    	final TilesViewResolver resolver = new TilesViewResolver();
////    	resolver.setViewClass(TilesView.class);
////    	resolver.setOrder(1);
////    	return resolver;
////	}
//    /*
//    @Bean
//	public UrlBasedViewResolver tilesViewResolver() {
//    	UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
//    	tilesViewResolver.setViewClass(TilesView.class);
//    	tilesViewResolver.setOrder(1);
//    	return tilesViewResolver;
//	}
//	*/
//
//    /**
//     * Exception Resolver를 설정한다.
//     */
////    @Bean
////    public SimpleMappingExceptionResolver getExceptionResolver() {
////
////        SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
////
////		// 지정되지 않은 예외에 대한 기본 에러페이지 입니다.
////		smer.setDefaultErrorView("com/lguplus/xr/common/error/error");
////		// 상태코드 맵핑이 없는 예외를 위한 기본 상태값 입니다.
////		smer.setDefaultStatusCode(500);
////		// 기본값이 "exception" 입니다. 예외 모돌 속성의 키값입니다. ${exception.message}
////		smer.setExceptionAttribute("exception");
////		// 하나 또는 그 이상의 예외를 리졸버에서 제외합니다. 제외된 예외는 web.xml에서 지정된 값이 적용됩니다.
////		//smer.setExcludedExceptions(UncheckException.class);
////		// 예외 클래스에 대해 에러 페이지를 지정합니다.
////		Properties mappings = new Properties();
////		mappings.setProperty("com.lguplus.xr.exception.IpAllowException", "common/error/errorIP");
////		mappings.setProperty("com.lguplus.xr.exception.AuthException", "common/error/errorAuth");
////		mappings.setProperty("com.lguplus.xr.exception.SessionException", "common/error/errorSession");
////		mappings.setProperty("com.lguplus.xr.exception.AjaxException", "common/error/errorAjax");
////		mappings.setProperty("com.lguplus.xr.exception.PageNotFoundException", "common/error/errorNoPage");
////		smer.setExceptionMappings(mappings);
////
////		// 에러페이지에 상태코드를 지정합니다.
////		Properties statusCodes = new Properties();
////		statusCodes.setProperty("common/error/errorIP", "500");
////		statusCodes.setProperty("common/error/errorAuth", "403");
////		statusCodes.setProperty("common/error/errorSession", "403");
////		statusCodes.setProperty("common/error/errorAjax", "200");
////		statusCodes.setProperty("common/error/errorNoPage", "404");
////		smer.setStatusCodes(statusCodes);
////
////		return smer;
////
////    }
//
//    @Bean
//    public MultipartResolver multipartResolver() {
//       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//       multipartResolver.setMaxUploadSize(-1);
//       //multipartResolver.setMaxUploadSize(MAX_SIZE); // 10MB
//       //multipartResolver.setMaxUploadSizePerFile(MAX_SIZE); // 10MB
//       //multipartResolver.setMaxInMemorySize(0);
//       return multipartResolver;
//    }
//
//}
